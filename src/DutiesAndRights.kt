interface DutiesAndRights {
    /*impl fun to calculate the tax% that a member in the community should pay */
    fun taxRate():Float
    /*impl fun to calculate the max sum of lone that a community member can get from the community */
    fun maxSumLone():Float
    /*impl fun to calculate the recommended hours that a member should volunteerl*/
    fun recommendedSumHoursToVolunteer():Float
}