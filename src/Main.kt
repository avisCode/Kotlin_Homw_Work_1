import java.time.LocalDate

fun main(args: Array<String>) {
    val community: Community = Community()
    /*adding members to the community and see if all can be added */
    try {
        community.addCommunityMember(Married(208509654, "beni", "Male", LocalDate.parse("1996-12-04"), "jerusalem 58 PT", 50F, 25f, 5000F, 318413079, 1, VolunteerOp.Physical))
        community.addCommunityMember(Married(208509644, "beni", "Male", LocalDate.parse("1996-12-04"), "jerusalem 58 PT", 49F, 21f, 59800F, 318433079, 4, VolunteerOp.Contribution))
        community.addCommunityMember(Married(208509644, "beni", "Male", LocalDate.parse("1996-12-04"), "jerusalem 58 PT", 49F, 31f, 12000F, 318433079, 4, VolunteerOp.Musical))
        community.addCommunityMember(Married(208509653, "Avi", "Male", LocalDate.parse("1996-11-04"), "Rutshild 58 PT", 2F, 55f, 150000F, 318413069, 1, VolunteerOp.Musical))
    } catch (e: IllegalArgumentException) {
        println("Sorry u can't join the Community because: ${e.message}")
    }

    /*sample of Kotlin_Object _Expression*/
    community.addCommunityMember(object : Married(123456789, "Rav", "Male", LocalDate.parse("1980-10-29"), "in the Shoul", 90F, 0F, 10000F, 987654321, 5, VolunteerOp.Contribution) {
        override fun taxRate(): Float {
            return 1F;
        }

        override fun maxSumLone(): Float {
            return 200000F
        }

        override fun recommendedSumHoursToVolunteer(): Float {
            return 10F
        }

    })

    /*getting the hours in etch volunteer of all community members */
    community.getAllVolunteersHoursOfCommunity().forEach { (t, u) ->
        println("hours of volunteer in $t is $u in total ${u.sum()}")
    }

    /*printing the sum of tax to collect from all community members */
    println("the sum of tax to collect from the community is ${community.getSumTexOfAllMembers()}INS")

    /*getting the max sum of one the a member can get from the community*/
    println("the max lone that the member can get is: ${community.getSumLoneForMember(208509654)} INS")
}