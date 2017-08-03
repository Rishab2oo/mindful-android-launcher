/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.telephony;

/**
 * Contains precise disconnect call causes generated by the
 * framework and the RIL.
 *
 * @hide
 */
public class PreciseDisconnectCause {

    /**
     * The disconnect cause is not valid (Not received a disconnect cause)
     */
    public static final int NOT_VALID = -1;
    /**
     * No disconnect cause provided. Generally a local disconnect or an incoming missed call
     */
    public static final int NO_DISCONNECT_CAUSE_AVAILABLE = 0;
    /**
     * The destination cannot be reached because the number, although valid,
     * is not currently assigned
     */
    public static final int UNOBTAINABLE_NUMBER = 1;
    /**
     * One of the users involved in the call has requested that the call is cleared
     */
    public static final int NORMAL = 16;
    /**
     * The called user is unable to accept another call
     */
    public static final int BUSY = 17;
    /**
     * The called number is no longer assigned
     */
    public static final int NUMBER_CHANGED = 22;
    /**
     * Provided in response to a STATUS ENQUIRY message
     */
    public static final int STATUS_ENQUIRY = 30;
    /**
     * Reports a normal disconnect only when no other normal cause applies
     */
    public static final int NORMAL_UNSPECIFIED = 31;
    /**
     * There is no channel presently available to handle the call
     */
    public static final int NO_CIRCUIT_AVAIL = 34;
    /**
     * The network is not functioning correctly and the condition is not likely to last
     * a long period of time
     */
    public static final int TEMPORARY_FAILURE = 41;
    /**
     * The switching equipment is experiencing a period of high traffic
     */
    public static final int SWITCHING_CONGESTION = 42;
    /**
     * The channel cannot be provided
     */
    public static final int CHANNEL_NOT_AVAIL = 44;
    /**
     * The requested quality of service (ITU-T X.213) cannot be provided
     */
    public static final int QOS_NOT_AVAIL = 49;
    /**
     * The requested bearer capability is not available at this time
     */
    public static final int BEARER_NOT_AVAIL = 58;
    /**
     * The call clearing is due to ACM being greater than or equal to ACMmax
     */
    public static final int ACM_LIMIT_EXCEEDED = 68;
    /**
     * The call is restricted
     */
    public static final int CALL_BARRED = 240;
    /**
     * The call is blocked by the Fixed Dialing Number list
     */
    public static final int FDN_BLOCKED = 241;
    /** The given IMSI is not known at the VLR */
    /**
     * TS 24.008 cause 4
     */
    public static final int IMSI_UNKNOWN_IN_VLR = 242;
    /**
     * The network does not accept emergency call establishment using an IMEI or not accept attach
     * procedure for emergency services using an IMEI
     */
    public static final int IMEI_NOT_ACCEPTED = 243;
    /**
     * MS is locked until next power cycle
     */
    public static final int CDMA_LOCKED_UNTIL_POWER_CYCLE = 1000;
    /**
     * Drop call
     */
    public static final int CDMA_DROP = 1001;
    /**
     * INTERCEPT order received, MS state idle entered
     */
    public static final int CDMA_INTERCEPT = 1002;
    /**
     * MS has been redirected, call is cancelled
     */
    public static final int CDMA_REORDER = 1003;
    /**
     * Service option rejection
     */
    public static final int CDMA_SO_REJECT = 1004;
    /**
     * Requested service is rejected, retry delay is set
     */
    public static final int CDMA_RETRY_ORDER = 1005;
    /**
     * Unable to obtain access to the CDMA system
     */
    public static final int CDMA_ACCESS_FAILURE = 1006;
    /**
     * Not a preempted call
     */
    public static final int CDMA_PREEMPTED = 1007;
    /**
     * Not an emergency call
     */
    public static final int CDMA_NOT_EMERGENCY = 1008;
    /**
     * Access Blocked by CDMA network
     */
    public static final int CDMA_ACCESS_BLOCKED = 1009;
    /**
     * Disconnected due to unspecified reasons
     */
    public static final int ERROR_UNSPECIFIED = 0xffff;

    /**
     * Private constructor to avoid class instantiation.
     */
    private PreciseDisconnectCause() {
        // Do nothing.
    }
}
