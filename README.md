# House of Cards
Team project for the second semester of university, written in Java

## Rules
The game is played by one person with one deck of cards with Jacks, Queens, Kings removed. Therefore the
deck contains only 40 cards: 10 cards (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10,) of each of the four Suits (Hearts,
Diamonds, Clubs, and Spades). There are also four Houses, i.e. stacks in which the player will be placing
cards.

#### The game is played as follows:
The computer randomly deals one-by-one the cards from the deck and the player
has to place each card in one of the different Houses trying to achieve a total of 31 in the House. The total is
calculated by adding the cards (Ace counts for 11 and the rest as they are, i.e. the 8 of Spades counts for 8).
Every time the player manages to achieve a score of 31 in one of the houses they win 100 points and the House becomes
empty (total = 0). If one House’s total exceeds 31, then this House is closed and the player cannot use it any
more. 

#### The game is finished when:
- all 40 cards of the deck are placed in the Houses at which point player’s total points are announced (player
wins), or when

- all four Houses become closed before the cards are exhausted (player loses and is awarded zero points).
