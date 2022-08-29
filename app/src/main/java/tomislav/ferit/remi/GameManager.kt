package tomislav.ferit.remi

import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlin.random.Random

class GameManager(
   val numberOfJokerCards: Int,
   val context: Context
) {

    var gameDeckOfCards = createGameDeckOfCards()
    var playerDeckOfCards =createPlayerDeckOfCards()

    var  savedStates = mutableListOf<Memento>()


    private fun createGameDeckOfCards() : MutableList<Card> {
        val gameDeckOfCards = mutableListOf<Card>(
            Card(R.drawable.card_club_2,2,"CLUB",false),
            Card(R.drawable.card_club_3,3,"CLUB",false),
            Card(R.drawable.card_club_4,4,"CLUB",false),
            Card(R.drawable.card_club_5,5,"CLUB",false),
            Card(R.drawable.card_club_6,6,"CLUB",false),
            Card(R.drawable.card_club_7,7,"CLUB",false),
            Card(R.drawable.card_club_8,8,"CLUB",false),
            Card(R.drawable.card_club_9,9,"CLUB",false),
            Card(R.drawable.card_club_10,10,"CLUB",false),
            Card(R.drawable.card_club_j,11,"CLUB",false),
            Card(R.drawable.card_club_q,12,"CLUB",false),
            Card(R.drawable.card_club_k,13,"CLUB",false),
            Card(R.drawable.card_club_a,14,"CLUB",false),
            Card(R.drawable.card_diamond_2,2,"DIAMOND",false),
            Card(R.drawable.card_diamond_3,3,"DIAMOND",false),
            Card(R.drawable.card_diamond_4,4,"DIAMOND",false),
            Card(R.drawable.card_diamond_5,5,"DIAMOND",false),
            Card(R.drawable.card_diamond_6,6,"DIAMOND",false),
            Card(R.drawable.card_diamond_7,7,"DIAMOND",false),
            Card(R.drawable.card_diamond_8,8,"DIAMOND",false),
            Card(R.drawable.card_diamond_9,9,"DIAMOND",false),
            Card(R.drawable.card_diamond_10,10,"DIAMOND",false),
            Card(R.drawable.card_diamond_j,11,"DIAMOND",false),
            Card(R.drawable.card_diamond_q,12,"DIAMOND",false),
            Card(R.drawable.card_diamond_k,13,"DIAMOND",false),
            Card(R.drawable.card_diamond_a,14,"DIAMOND",false),
            Card(R.drawable.card_heart_2,2,"HEART",false),
            Card(R.drawable.card_heart_3,3,"HEART",false),
            Card(R.drawable.card_heart_4,4,"HEART",false),
            Card(R.drawable.card_heart_5,5,"HEART",false),
            Card(R.drawable.card_heart_6,6,"HEART",false),
            Card(R.drawable.card_heart_7,7,"HEART",false),
            Card(R.drawable.card_heart_8,8,"HEART",false),
            Card(R.drawable.card_heart_9,9,"HEART",false),
            Card(R.drawable.card_heart_10,10,"HEART",false),
            Card(R.drawable.card_heart_j,11,"HEART",false),
            Card(R.drawable.card_heart_q,12,"HEART",false),
            Card(R.drawable.card_heart_k,13,"HEART",false),
            Card(R.drawable.card_heart_a,14,"HEART",false),
            Card(R.drawable.card_spade_2,2,"SPADE",false),
            Card(R.drawable.card_spade_3,3,"SPADE",false),
            Card(R.drawable.card_spade_4,4,"SPADE",false),
            Card(R.drawable.card_spade_5,5,"SPADE",false),
            Card(R.drawable.card_spade_6,6,"SPADE",false),
            Card(R.drawable.card_spade_7,7,"SPADE",false),
            Card(R.drawable.card_spade_8,8,"SPADE",false),
            Card(R.drawable.card_spade_9,9,"SPADE",false),
            Card(R.drawable.card_spade_10,10,"SPADE",false),
            Card(R.drawable.card_spade_j,11,"SPADE",false),
            Card(R.drawable.card_spade_q,12,"SPADE",false),
            Card(R.drawable.card_spade_k,13,"SPADE",false),
            Card(R.drawable.card_spade_a,14,"SPADE",false),
            Card(R.drawable.card_club_2,2,"CLUB",false),   //2. špil
            Card(R.drawable.card_club_3,3,"CLUB",false),
            Card(R.drawable.card_club_4,4,"CLUB",false),
            Card(R.drawable.card_club_5,5,"CLUB",false),
            Card(R.drawable.card_club_6,6,"CLUB",false),
            Card(R.drawable.card_club_7,7,"CLUB",false),
            Card(R.drawable.card_club_8,8,"CLUB",false),
            Card(R.drawable.card_club_9,9,"CLUB",false),
            Card(R.drawable.card_club_10,10,"CLUB",false),
            Card(R.drawable.card_club_j,11,"CLUB",false),
            Card(R.drawable.card_club_q,12,"CLUB",false),
            Card(R.drawable.card_club_k,13,"CLUB",false),
            Card(R.drawable.card_club_a,14,"CLUB",false),
            Card(R.drawable.card_diamond_2,2,"DIAMOND",false),
            Card(R.drawable.card_diamond_3,3,"DIAMOND",false),
            Card(R.drawable.card_diamond_4,4,"DIAMOND",false),
            Card(R.drawable.card_diamond_5,5,"DIAMOND",false),
            Card(R.drawable.card_diamond_6,6,"DIAMOND",false),
            Card(R.drawable.card_diamond_7,7,"DIAMOND",false),
            Card(R.drawable.card_diamond_8,8,"DIAMOND",false),
            Card(R.drawable.card_diamond_9,9,"DIAMOND",false),
            Card(R.drawable.card_diamond_10,10,"DIAMOND",false),
            Card(R.drawable.card_diamond_j,11,"DIAMOND",false),
            Card(R.drawable.card_diamond_q,12,"DIAMOND",false),
            Card(R.drawable.card_diamond_k,13,"DIAMOND",false),
            Card(R.drawable.card_diamond_a,14,"DIAMOND",false),
            Card(R.drawable.card_heart_2,2,"HEART",false),
            Card(R.drawable.card_heart_3,3,"HEART",false),
            Card(R.drawable.card_heart_4,4,"HEART",false),
            Card(R.drawable.card_heart_5,5,"HEART",false),
            Card(R.drawable.card_heart_6,6,"HEART",false),
            Card(R.drawable.card_heart_7,7,"HEART",false),
            Card(R.drawable.card_heart_8,8,"HEART",false),
            Card(R.drawable.card_heart_9,9,"HEART",false),
            Card(R.drawable.card_heart_10,10,"HEART",false),
            Card(R.drawable.card_heart_j,11,"HEART",false),
            Card(R.drawable.card_heart_q,12,"HEART",false),
            Card(R.drawable.card_heart_k,13,"HEART",false),
            Card(R.drawable.card_heart_a,14,"HEART",false),
            Card(R.drawable.card_spade_2,2,"SPADE",false),
            Card(R.drawable.card_spade_3,3,"SPADE",false),
            Card(R.drawable.card_spade_4,4,"SPADE",false),
            Card(R.drawable.card_spade_5,5,"SPADE",false),
            Card(R.drawable.card_spade_6,6,"SPADE",false),
            Card(R.drawable.card_spade_7,7,"SPADE",false),
            Card(R.drawable.card_spade_8,8,"SPADE",false),
            Card(R.drawable.card_spade_9,9,"SPADE",false),
            Card(R.drawable.card_spade_10,10,"SPADE",false),
            Card(R.drawable.card_spade_j,11,"SPADE",false),
            Card(R.drawable.card_spade_q,12,"SPADE",false),
            Card(R.drawable.card_spade_k,13,"SPADE",false),
            Card(R.drawable.card_spade_a,14,"SPADE",false)
        )

        for(i in 0 until this.numberOfJokerCards){
            gameDeckOfCards.add(Card(R.drawable.joker,100,"JOKER",false))
        }

        return gameDeckOfCards

    }

   private fun createPlayerDeckOfCards(): MutableList<Card>{
       val playerDeckCards= mutableListOf<Card>()

       var seed = Random.nextInt()
       val randomIterator = RandomIntIterator(0 until 9999)
       if(randomIterator.hasNext()){
            seed= randomIterator.next()
       }
       else{
           //renew if needed
           randomIterator.randomize()
       }
       for(i in 0..14){

           val randomPosition = Random(seed).nextInt(0,this.gameDeckOfCards.size-1)
           playerDeckCards.add(this.gameDeckOfCards[randomPosition])
           this.gameDeckOfCards.removeAt(randomPosition)

       }
        return playerDeckCards
   }


    fun switchTwoCheckedCards(oldPlayerDeckOfCards : MutableList<Card>): MutableList<Card>{

        val positions = arrayListOf<Int>()
        for(position in 0 until oldPlayerDeckOfCards.size){

            if(oldPlayerDeckOfCards[position].isChecked)
                positions.add(position)
        }

        for(i in 0 until positions.size)

            if(positions.size != 2) {
                Toast.makeText(
                    context,
                    "You checked ${positions.size} checkboxes instead of 2!",
                    Toast.LENGTH_LONG
                ).show()

                return oldPlayerDeckOfCards
            }

            val newPlayerDeckOfCards= swapAndUncheck(oldPlayerDeckOfCards, positions[0], positions[1])
            return newPlayerDeckOfCards
    }



    private fun swapAndUncheck(
        listToSwap: MutableList<Card>,
        position1: Int,
        position2: Int
    ): MutableList<Card> {

        val tmp = listToSwap[position1]
        listToSwap[position1] = listToSwap[position2]
        listToSwap[position2] = tmp

        listToSwap[position1].isChecked=false
        listToSwap[position2].isChecked=false


        return listToSwap
    }


    fun replace(PlayerDeckOfCards : MutableList<Card>): MutableList<Card>{

        val positions = arrayListOf<Int>()
        for(position in 0 until PlayerDeckOfCards.size){

            if(PlayerDeckOfCards[position].isChecked)
                positions.add(position)

        }
        if(positions.size != 1) {
            Toast.makeText(
                context,
                "You checked ${positions.size} checkboxes instead of 1!",
                Toast.LENGTH_LONG
            ).show()
            return PlayerDeckOfCards  //return the same as inputted

        }
        val randomPositionInGameDeck = Random.nextInt(0,this.gameDeckOfCards.size-1)
        val newCard=this.gameDeckOfCards[randomPositionInGameDeck]
        gameDeckOfCards.removeAt(randomPositionInGameDeck)                                          //uzimanje karte iz "slobodnog" špila
        PlayerDeckOfCards.removeAt(positions[0])                                                        //samo jedna pozicija
        PlayerDeckOfCards.add(positions[0],newCard)
        return PlayerDeckOfCards
    }

     private fun save(discardedCards : List<Card>) {
         savedStates.add(Memento(discardedCards))
     }
    fun restoreFromMemento(): List<Card> {
        if(savedStates.isEmpty())
            throw (Exception("SavedStates are empty!"))
        return savedStates.removeLast().getDiscardedCards()

    }

    fun discardCheckedCards(playerCards :MutableList<Card>) : MutableList<Card>{

        val positions = arrayListOf<Int>()
        for(position in 0 until playerCards.size){
            if(playerCards[position].isChecked)
                positions.add(position)
        }
        val playerCardsToBeChecked = mutableListOf<Card>()
        for(position in 0 until positions.size){
            playerCardsToBeChecked.add(playerCards[positions[position]])
        }
        if(isThreeOrMoreInARow(playerCardsToBeChecked)){                                                                                    //micanje karata iz igračevog špila i spremanje u memento ako su uvjeti zadovoljeni
            save(playerCardsToBeChecked)
            for(position in positions.size -1 downTo(0) ){                                                                                  //od zadnjeg indexa do nultog da nemijenjamo redoslijed ostalih karata koje ce biti izbacivane
                playerCards.removeAt(positions[position])
            }
            Toast.makeText(this.context,
                "You sucssesfully removed your cards",
                Toast.LENGTH_LONG).show()
        }
        else if(isThreeOrFourOfSameNumAndDifSuit(playerCardsToBeChecked)){                                                                      //micanje 3 ili 4 karte istog broja razlicitih boja
            save(playerCardsToBeChecked)
            for(position in positions.size -1 downTo(0) ){                                                                                      //od zadnjeg indexa do nultog da nemijenjamo redoslijed ostalih karata koje ce biti izbacivane
                playerCards.removeAt(positions[position])
            }
            Toast.makeText(this.context,
                "You sucssesfully removed your cards",
                Toast.LENGTH_LONG).show()
        }
        return playerCards
    }

    private fun isThreeOrMoreInARow(cardsToBeCheckedForDiscarding : MutableList<Card>) : Boolean{

        val sortedCardsToBeCheckedForDiscarding = cardsToBeCheckedForDiscarding.sortedBy { it.numberValue }                     //uzlazno sortirani
        var possibleAceFlag= false
        var jokerCounter=0
        for(position in 0 until sortedCardsToBeCheckedForDiscarding.size){
            if(isJoker(sortedCardsToBeCheckedForDiscarding[position])) { //Ako je Joker karta
                jokerCounter++
            }
        }
        if(sortedCardsToBeCheckedForDiscarding.size<3){
            return false
        }
        for(position in 0 .. sortedCardsToBeCheckedForDiscarding.size -2){
            val card= sortedCardsToBeCheckedForDiscarding[position]
            val numberValue =card.numberValue
            val suit =card.suit
            if(card.numberValue==2){ possibleAceFlag=true}                                                                           //ako je prva karta 2, As moze sudjelovat u nizu

            val nextCard=sortedCardsToBeCheckedForDiscarding[position+1]
            val nextNumberValue=nextCard.numberValue
            val nextSuit =nextCard.suit

            if(isJoker(card) || isJoker(nextCard)){
                break                                                                                                                       //Posto je lista karata uzlazno sortirana po "numberValue" karata, joker karte ce biti zadnje u listi  //pa mozemo zaustaviti for petlju
            }
            else if(suit != nextSuit) {
                return false
            }
            else if( nextNumberValue-numberValue != 1){                                                                                                 //razlika mora biti za jedan i karte moraju biti u istoj boji
                if(possibleAceFlag==true){
                    if(isAce(nextCard)) {
                        continue
                    }
                }
                if(jokerCounter>0){
                    jokerCounter--
                    continue
                }
                return false
            }
        }
        return true
    }

    private fun isThreeOrFourOfSameNumAndDifSuit(cardsToBeCheckedForDiscarding : MutableList<Card>) : Boolean {

        if(cardsToBeCheckedForDiscarding.size<3 || cardsToBeCheckedForDiscarding.size>4){
            return false
        }
        val copyOfCardsToBeCheckedForDiscarding= mutableListOf<Card>()
        for(position in 0 until cardsToBeCheckedForDiscarding.size){
            copyOfCardsToBeCheckedForDiscarding.add(cardsToBeCheckedForDiscarding[position])
        }
        val cardsWithoutJokers = removeJokers(copyOfCardsToBeCheckedForDiscarding)                                              //micanje jokera
        var counter = 0
        for(position1 in 0 until cardsWithoutJokers.size){
             counter = 0
            val card1=cardsWithoutJokers[position1]
            for(position2 in 0 until cardsWithoutJokers.size){
                val card2= cardsWithoutJokers[position2]

                if(card1.numberValue != card2.numberValue){                                                                     //ako ijedna karta nije istog broja sa ostalima
                    return false
                }
                if(card1.suit == card2.suit){
                    counter++
                    Log.d("counter2","counter[$position2] $counter")
                    if(counter>1){                                                                                                  //u usporedbi ce se samo jednom ponovit da se karta sa samom sobom usporedi
                        return false
                    }
                }
            }
        }
        return true




    }

    private fun removeJokers(cards: MutableList<Card>) : MutableList<Card>{

        val positions = arrayListOf<Int>()
        for(position in 0 until cards.size)
            if(isJoker(cards[position])){
                positions.add(position)
            }

        for(position in positions.size-1 downTo(0)){
            cards.removeAt(positions[position])
        }

        return cards
    }

    private fun isJoker(card: Card) : Boolean {
        if(card.numberValue==100) {
            return true
        }

        return false
    }

    private fun isAce(card: Card) : Boolean {
        if(card.numberValue==14) {
            return true
        }

        return false
    }

    fun sortAllChecked(playerCards: MutableList<Card>): MutableList<Card>{

        val sortedPlayerCards = mutableListOf<Card>()

        val copyOfPlayerCards= mutableListOf<Card>()
        for(position in 0 until playerCards.size){
            copyOfPlayerCards.add(playerCards[position])
        }

        val clubCards = mutableListOf<Card>()
        val heartCards = mutableListOf<Card>()
        val spadeCards = mutableListOf<Card>()
        val diamondCards = mutableListOf<Card>()
        val jokers = mutableListOf<Card>()

        val positions = arrayListOf<Int>()

        for(position in 0 until playerCards.size){
            if(playerCards[position].isChecked) {
                if (playerCards[position].suit == "CLUB"){
                    clubCards.add(playerCards[position])
                    positions.add(position)
                }
                else if (playerCards[position].suit == "HEART"){
                    heartCards.add(playerCards[position])
                    positions.add(position)
                }
                else if (playerCards[position].suit == "SPADE"){
                    spadeCards.add(playerCards[position])
                    positions.add(position)
                }
                else if (playerCards[position].suit == "DIAMOND"){
                    diamondCards.add(playerCards[position])
                    positions.add(position)
                }
                else if(isJoker(playerCards[position])){
                    jokers.add(playerCards[position])
                    positions.add(position)
                }
            }
        }

        for(position in positions.size-1 downTo(0)){
            copyOfPlayerCards.removeAt(positions[position])
        }

        if(clubCards.isNotEmpty()){
            clubCards.sortBy { it.numberValue }
            for(position in 0 until clubCards.size){
                sortedPlayerCards.add(clubCards[position])
            }
        }
        if(heartCards.isNotEmpty()){
            heartCards.sortBy { it.numberValue }
            for(position in 0 until heartCards.size){
                sortedPlayerCards.add(heartCards[position])
            }
        }
        if(spadeCards.isNotEmpty()){
            spadeCards.sortBy { it.numberValue }
            for(position in 0 until spadeCards.size){
                sortedPlayerCards.add(spadeCards[position])
            }
        }
        if(diamondCards.isNotEmpty()){
            diamondCards.sortBy { it.numberValue }
            for(position in 0 until diamondCards.size){
                sortedPlayerCards.add(diamondCards[position])
            }
        }

        if(jokers.isNotEmpty()){
            for(position in 0 until jokers.size){
                sortedPlayerCards.add(jokers[position])
            }
        }

        if(copyOfPlayerCards.isNotEmpty()){
            for(position in 0 until copyOfPlayerCards.size){                                                    ////naposlijetku dodajemo one karte koje korisnik ne želi sortirati
                sortedPlayerCards.add(copyOfPlayerCards[position])
            }
        }

        if(sortedPlayerCards.isEmpty())
            return playerCards

        return sortedPlayerCards

    }

}