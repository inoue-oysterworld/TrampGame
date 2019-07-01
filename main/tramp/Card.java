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

	public Card() {
		this("クローバー", 2);

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
			switch (s[i]) {
			case "スペード":
				markCompare[i] = 4;
				break;

			case "ハート":
				markCompare[i] = 3;
				break;

			case "ダイヤ":
				markCompare[i] = 2;
				break;

			case "クローバー":
				markCompare[i] = 1;
				break;

			default:
				markCompare[i] = 5; //ジョーカーは5として扱う
				break;
			}

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

}
