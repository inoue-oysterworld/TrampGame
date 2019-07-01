package tramp;

public class Card {//カード
	//フィールド変数、カプセル化
	private String mark;//マーク
	private int number;//番号

	//ゲッターとセッター
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getNum() {//絵札変換
		String picture;
		switch (this.number) {
		case 1:
			picture = "A";
			break;
		case 11:
			picture = "J";
			break;
		case 12:
			picture = "Q";
			break;
		case 13:
			picture = "K";
			break;
		case 14:
			picture = "Joker";
			break;
		default:
			picture = String.valueOf(this.number);//番号カードはそのまま文字列型に変換
		}
		return picture;
	}

	public void setNum(int number) {
		this.number = number;
	}

	//コンストラクタ
	public Card(String mark, int number) {
		this.mark = mark;
		this.number = number;

	}

	int compareTo(Card anotherCard) { //カードの強さを単純に比較
		int compare;
		int a = this.power();
		int b = anotherCard.power();
		if (a > b) {
			compare = 1;

		} else if (a < b) {
			compare = -1;

		} else { //引き分けだった場合、マークでも比較
			compare = MarkCompareTo(anotherCard);
		}

		return compare;
	}

	int power() {
		int power;
		switch (this.number) {
		case 1:
			power = 14;
			break;

		case 14:
			power = 15;
			break;

		default:
			power = this.number;
		}

		return power;
	}

	private int MarkCompareTo(Card anotherCard) { //マーク比較
		String[] s = { this.getMark(), anotherCard.getMark() };
		int[] markCompare = new int[2];
		int compareResult;
		for (int i = 0; i < 2; i++) {
			markCompare[i] = getMarkPower(s[i]);

		}
		if (markCompare[0] > markCompare[1]) {
			compareResult = 1;

		} else if (markCompare[0] < markCompare[1]) {
			compareResult = -1;

		} else {
			compareResult = 0;

		}
		return compareResult;

	}

	private int getMarkPower(String mark) {
		int markPower;
		switch (mark) {
		case "スペード":
			markPower = 4;
			break;

		case "ハート":
			markPower = 3;
			break;

		case "ダイヤ":
			markPower = 2;
			break;

		case "クローバー":
			markPower = 1;
			break;

		default:
			markPower = 5; //ジョーカーは5として扱う
			break;
		}
		return markPower;
	}

	public static Card createJoker() {
		Card card = new Card("Joker", 14);
		return card;
	}

	public static Card chooseBestCard(Card[] cardArray) {
		Card strongest = cardArray[0];//一番強いカード
		for (int i = 1; i < cardArray.length; i++) {//配列長-1回繰り返し
			if (strongest.power() < cardArray[i].power()) {//最大値と比較
				if (cardArray[i].power() > strongest.power()) {//配列のi番目とstrongestの大小を比較
					strongest = cardArray[i];

				} else if (cardArray[i].power() == strongest.power()) {//最大値が等しいとき、マークを比較
					if (cardArray[i].compareTo(strongest) == 1) {
						strongest = cardArray[i];
					} else {
						//何もしない
					}

				} else {
					//何もしない
				}

			} else {
				//何もしない
			}

		}
		return strongest;
	}
}
