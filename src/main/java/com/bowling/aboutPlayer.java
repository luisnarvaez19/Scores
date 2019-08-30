package com.bowling;

public interface aboutPlayer {
    /**
     * Verify data line has only two fields
     * Verify data line first field is String, second field is a integer or a F
     *
     * @param data data player's line
     * @return null if the fields are good else the reason why is wrong
     */
    public default String areBadFields(String data) {
        return null;
    }

    /**
     * Verify if the second field is Negative
     * Verify if the second field is > 10
     * @param data
     * @return null if the field is good else the reason why is wrong
     */
    public String isBadScore(String data);


    /**
     * Verify if he Player is in the BlackList for no read more his registers
     * @param data
     * @return
     */
    public Boolean isInBlackList(String data);

    /**
     *
     * @param data
     * @return
     */
    public Boolean hasMoreThrows(String data);

}
