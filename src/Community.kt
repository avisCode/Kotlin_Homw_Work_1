import java.lang.Exception

/*the community class*/
class Community() {
    /*dic with all community members with key = member id and value = the member obj*/
    private var community = linkedMapOf<Int, CommunityMember>()

    /*add a member to the community */
    fun addCommunityMember(member: CommunityMember) {
        community[member.id] = member
    }

    /*get the sum tax to be collect  from all community members */
    fun getSumTexOfAllMembers(): Float {
        return community.map { it.value.taxRate() / 100 * it.value.income }.sum()
    }

    /**
     * the fun returns the sum of lone a member can get from the community
     * @param id Int = of a community member
     * @return Float?
     */
    fun getSumLoneForMember(id: Int): Float? {
        if (!community.containsKey(id))
            throw IllegalArgumentException("member with id: $id is not in the community")
        return community[id]?.maxSumLone()
    }


    /**
     * the fun returns a dic of the number of hours in witch volunteer option
     * @return Map<VolunteerOp, List<Float>> exc:{Physical=[28.0], Contribution=[2.0, 0.0]}
     */
    fun getAllVolunteersHoursOfCommunity(): Map<VolunteerOp, List<Float>> {
        return (community.asSequence().groupBy({ it.value.kindOfVolunteer }, { it.value.recommendedSumHoursToVolunteer() }))
    }
}