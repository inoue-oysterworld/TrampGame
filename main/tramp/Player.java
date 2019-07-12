package tramp;

public class Player {

	//プライベート変数
	private String name;
	private Card[] cards = new Card[5];//カードの所持枠

	//コンストラクタ
	public Player(String name) {
		this.name = name;
	}

	//ゲッター
	public String getName() {
		return this.name;
	}

	public void drawByPlayer(int cardIndex, Deck deck) {//Playerがカードを1枚引く
		Card card = deck.draw();
		cards[cardIndex] = card;
		System.out.println((cardIndex + 1) + "枚目：" + card.getMark() + "の" + card.getNum() + "を引きました。");//カードのマークと番号を取得

	}

	public void putByPlayer() {//Playerがカードを1枚戻す

	}

	//playerが持っているカードの情報表示
	public void showCurrentCardList() {
		for (int i = 0; i < this.cards.length; i++) {
			Card card = cards[i];
			System.out.println((i + 1) + "枚目：" + card.getMark() + "の" + card.getNum());
		}
	}

	//カードを交換する
	public void changeCard(int cardIndex, Deck deck) {
		try {
			Card card = this.cards[cardIndex];
			deck.putDown(card);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("1～5の整数で選んでください！！");
			System.out.println(this.name + "のせいでゲームが終了しました。");
		}
		this.drawByPlayer(cardIndex, deck);
	}

}
