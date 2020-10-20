import java.time.LocalDate

/* a married community member */
open class Married(id: Int, name: String, sex: String, dob: LocalDate, address: String, learningHours: Float, workingHours: Float,
                   income: Float, partnerId: Int, numOfKids: Int, kindOfVolunteer: VolunteerOp) :
        CommunityMember(id, name, sex, dob, address, learningHours, workingHours, income, kindOfVolunteer) {
    var partnerId: Int = partnerId
        private set
    var numOfKids: Int = numOfKids
        private set

    /**
     * @return the tax rate the member should pay base on the learning hours and num kids
     */
    override fun taxRate(): Float {
        if (learningHours >= 40F) return 1F
        return 40 / (learningHours + numOfKids * 2)
    }

    /**
     * @return the max Sum lone the a community member can get base on the income and num of kids
     */
    override fun maxSumLone(): Float {
        return when (income) {
            in 0.0..10000.0 -> 200000F + (10000 * numOfKids)
            in 10000.0..2000000.0 -> 100000F + (10000 * numOfKids)
            else -> 0F
        }
    }

    /**
     * @return the recommended num Hours To Volunteer base on  the kind of Volunteer and num kids
     */
    override fun recommendedSumHoursToVolunteer(): Float {
        return when (kindOfVolunteer) {
            VolunteerOp.Contribution -> 10F - numOfKids * 2
            VolunteerOp.Musical -> 20F - numOfKids * 2
            VolunteerOp.Physical -> 30F - numOfKids * 2
        }
    }

    override fun toString(): String {
        return super.toString() + "Married(partnerId=$partnerId, numOfKids=$numOfKids)"
    }
}