package com.zalocoders.onlinemenu

import java.util.*
internal object ExpandableListData {
    val data: HashMap<String, List<String>>
        get() {
            val expandableListDetail =
                HashMap<String, List<String>>()
            val myFavCricketPlayers: MutableList<String> =
                ArrayList()
            myFavCricketPlayers.add("Tea  50 ksh")
            myFavCricketPlayers.add("Chapati 20ksh")

            val myFavFootballPlayers: MutableList<String> = ArrayList()
            myFavFootballPlayers.add("Chapo + Beans  120 ksh")
            myFavFootballPlayers.add("Ugali + Fish  200 ksh")

            val myFavTennisPlayers: MutableList<String> = ArrayList()
            myFavTennisPlayers.add("CocaCola  40 ksh")
            myFavTennisPlayers.add("Vanilla  120 ksh")
            myFavTennisPlayers.add("juice  100 skh")

            expandableListDetail["BREAKFAST"] = myFavCricketPlayers
            expandableListDetail["LUNCH"] = myFavFootballPlayers
            expandableListDetail["DRINKS"] = myFavTennisPlayers
            return expandableListDetail
        }
}