import java.time.LocalDate


abstract class CommunityMember(id: Int, name: String, sex: String, dob: LocalDate,
                               address: String, learningHours: Float, workingHours: Float,
                               income: Float, kindOfVolunteer: VolunteerOp, numOfExploit: Int = 0) : DutiesAndRights {

    /* the init will check minimum requirements to become a community member */
    init {
        if (learningHours < MINIMUM_LEARNING_HOURS)
            throw (java.lang.IllegalArgumentException(" $name Potz U need yo learn more then $MINIMUM_LEARNING_HOURS"))
        if (learningHours + workingHours <= MINIMUN_HOURS)
            throw (IllegalArgumentException("""$name Shmok move your self... 
                    to be a community member you nee to work in learn at list $MINIMUN_HOURS hours of work and learning """))
    }

    /*static fields*/
    companion object {
        const val MINIMUN_HOURS = 41
        const val MINIMUM_LEARNING_HOURS = 7
    }

    var id = id
        private set
    var name = name
        private set
    var sex = sex
        private set
    var dataOfBirth = dob
        private set
    var address = address
        private set
    var learningHours = learningHours
        private set
    var workingHours = workingHours
        private set
    var income = income
        private set
    var numOfExploit = numOfExploit
        private set
    var kindOfVolunteer = kindOfVolunteer
        private set

    override fun toString(): String {
        return "CommunityMember(id=$id, name='$name', sex='$sex', dataOfBirth=$dataOfBirth, address='$address', learningHours=$learningHours, workingHours=$workingHours, income=$income, numOfExploit=$numOfExploit, kindOfVolunteer=$kindOfVolunteer)"
    }
}