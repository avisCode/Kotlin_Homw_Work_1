import java.time.LocalDate

/* a single community member */
class Single(id: Int, name: String, sex: String, dob: LocalDate, address: String, learningHours: Float, workingHours: Float,
             income: Float, numOfExploit: Int, kindOfVolunteer: VolunteerOp, numLearningYears: Float)
    : CommunityMember(id, name, sex, dob, address, learningHours, workingHours, income, kindOfVolunteer, numOfExploit) {
    var numLearningYears: Float = numLearningYears
        private set

    /**
     * @return the tax rate the member should pay base on the learning hours and num learning years
     */
    override fun taxRate(): Float {
        if (learningHours >= 60F) return 1F
        return 40 / (learningHours + numLearningYears)
    }

    /**
     * @return the max Sum lone the a community member can get base on the income
     */
    override fun maxSumLone(): Float {
        when (income) {
            in 0.0..10000.0 -> 200000F
            in 10000.0..2000000.0 -> 100000F
            else -> 0F
        }
        return 0F
    }

    /**
     * @return the recommended num Hours To Volunteer base on  the kind of Volunteer
     */
    override fun recommendedSumHoursToVolunteer(): Float {
        when (kindOfVolunteer) {
            VolunteerOp.Contribution -> 10F
            VolunteerOp.Musical -> 20F
            VolunteerOp.Physical -> 30F

        }
        return 30F
    }

    override fun toString(): String {
        return "Single(numLearningYears=$numLearningYears)"
    }
}