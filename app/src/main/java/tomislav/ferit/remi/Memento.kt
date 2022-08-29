package tomislav.ferit.remi

 class Memento (
     private val discardedCards : List<Card>
         ){

     public fun getDiscardedCards(): List<Card>{
         return this.discardedCards
     }

}