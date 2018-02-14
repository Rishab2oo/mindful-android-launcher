package co.siempo.phone.adapters.viewholder;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import co.siempo.phone.R;
import co.siempo.phone.activities.AppAssignmentActivity;
import co.siempo.phone.activities.JunkfoodFlaggingActivity;
import co.siempo.phone.app.CoreApplication;
import co.siempo.phone.models.AppMenu;
import co.siempo.phone.utils.DrawableProvider;
import co.siempo.phone.utils.PrefSiempo;


public class AppAssignmentAdapter extends RecyclerView.Adapter<AppAssignmentAdapter.ViewHolder> {

    private final Context context;
    private List<ResolveInfo> resolveInfoList;
    private HashMap<Integer, AppMenu> map;
    private DrawableProvider mProvider;
    private int id;

    public AppAssignmentAdapter(Context context, int id, List<ResolveInfo> resolveInfoList) {
        this.context = context;
        this.resolveInfoList = resolveInfoList;
        this.id = id;
        map = CoreApplication.getInstance().getToolsSettings();
        mProvider = new DrawableProvider(context);
    }

    @Override
    public AppAssignmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.list_item_app_assignment, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ResolveInfo item = resolveInfoList.get(position);
        if (item != null) {
            holder.txtAppName.setText(item.loadLabel(context.getPackageManager()));
            String packageName = item.activityInfo.packageName;
            if (PrefSiempo.getInstance(context).read(PrefSiempo.JUNKFOOD_APPS, new HashSet<String>()).contains(packageName)) {
                holder.btnHideApps.setVisibility(View.VISIBLE);
                Drawable drawable = mProvider.getRound("" + item.loadLabel(context.getPackageManager()).charAt(0), R.color.app_assignment_junkfood);
                holder.imgIcon.setImageDrawable(drawable);
                holder.btnHideApps.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, JunkfoodFlaggingActivity.class);
                        context.startActivity(intent);
                    }
                });
            } else {
                holder.imgIcon.setImageDrawable(CoreApplication.getInstance().getApplicationIconFromPackageName(item.activityInfo.packageName));
                holder.btnHideApps.setVisibility(View.GONE);
                holder.txtAppName.setTextColor(ContextCompat.getColor(context, R.color.app_assignment_normal));
                holder.linearList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (holder.btnHideApps.getVisibility() != View.VISIBLE) {
                            HashMap<Integer, AppMenu> map = CoreApplication.getInstance().getToolsSettings();
                            map.get(id).setApplicationName(item.activityInfo.packageName);
                            String hashMapToolSettings = new Gson().toJson(map);
                            PrefSiempo.getInstance(context).write(PrefSiempo.TOOLS_SETTING, hashMapToolSettings);
                            ((AppAssignmentActivity) context).finish();
                        }
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return resolveInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        ImageView imgIcon;
        TextView txtAppName;
        Button btnHideApps;
        RelativeLayout linearList;

        public ViewHolder(View v) {
            super(v);
            imgIcon = v.findViewById(R.id.imgIcon);
            txtAppName = v.findViewById(R.id.txtAppName);
            btnHideApps = v.findViewById(R.id.btnHideApps);
            linearList = v.findViewById(R.id.linearList);
        }
    }
}
