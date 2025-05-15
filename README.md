Hello and welcome to our game of Go Fish!

House rules:
1. After taking a card from your opponent,
your turn is over.


Deleted code:

1. A method from Hand class, used to print an unsorted Player hand

public void printHand(Player player) {
if (player.hand == null || player.hand.handArray == null || player.hand.handArray.isEmpty()) {
System.out.println("\nYour hand is empty");
} else {
for (Card card : player.hand.handArray) {
System.out.println(card.getValueAsString(card.getValue()) + " of " + card.getSuitAsString(card.getSuit()));
}
}
}


2. A method from Deck class, used to print how many cards remain in the deck

public void cardsLeft() {
System.out.println(deck.size());
}