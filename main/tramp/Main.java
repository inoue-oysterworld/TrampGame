package tramp;

import lib.Input;

public class Main {

	public static void main(String[] args) {
		System.out.println("実行する処理を選んでください");
		System.out.println(
				"1:ただデッキを用意して適当にカードを引く\n"
						+ "2:デッキを用意して2枚カードを引いて強さを比較する\n"
						+ "3:デッキを用意してカードを引いて引いた順に置いてまた引いてみる\n"
						+ "4:デッキを用意して適当にカードを引いて一番強いカードを示す\n"
						+ "それ以外：終了");
		byte a = Input.getByte("1～4の整数");
		System.out.println("処理を開始します\n---------------");

		switch (a) {
		case 1:
			byte first;
			do {
				Deck deck = new Deck();
				deck.shuffle();
				System.out.println("山札は現在" + deck.size() + "枚です");

				int count = Input.getInt("何枚引きますか?");//ドローフォームを表示
				if (count == 0) {
					System.out.println("パスします");

				} else if (deck.size() - count >= 0) {//有効値判定

					for (int i = 0; i < count; i++) {
						Card card = deck.draw();//カードを1枚引く
						System.out.println(card.getMark() + "の" + card.getNum() + "を引きました。");//カードのマークと番号を取得
					}

				} else {
					System.out.println("エラー：" + deck.size() + "以下の整数値を入力してください\n処理を終了します");
				}

				first = Input.getByte("同じルールでまだ続けますか?\nEnter=続行\t1=終了");

			} while (first == 0);
			break;

		case 2:
			byte second;
			do {
				Deck deck = new Deck();
				deck.shuffle();
				System.out.println("山札は現在" + deck.size() + "枚です");
				System.out.println("2枚ドローして大小比較します");
				Card card1 = deck.draw();
				System.out.println(card1.getMark() + "の" + card1.getNum() + "を引きました。");//カードのマークと番号を取得
				Card card2 = deck.draw();
				System.out.println(card2.getMark() + "の" + card2.getNum() + "を引きました。");//カードのマークと番号を取得
				int compare = card1.compareTo(card2);
				if (compare > 0) {
					System.out.println("前者の勝ちです");

				} else if (compare < 0) {
					System.out.println("後者の勝ちです");

				} else {
					System.out.println("引き分けです");
				}

				second = Input.getByte("同じルールでまだ続けますか?\nEnter=続行\t1=終了");

			} while (second == 0);
			break;
		case 3:
			byte third;
			do {
				Deck deck = new Deck();
				deck.shuffle();
				System.out.println("山札は現在" + deck.size() + "枚です");
				int count = Input.getInt("何枚引きますか?");//ドローフォームを表示
				if (count == 0) {
					System.out.println("パスします");

				} else if (deck.size() - count >= 0) {//有効値判定
					System.out.println(count + "枚ドローしてそれを置き、また" + count + "枚引きます");

					for (int i = 0; i < count; i++) {
						Card card = deck.draw();//カードを1枚引く
						System.out.println(card.getMark() + "の" + card.getNum() + "を引きました。");//カードのマークと番号を取得
					}

				} else {
					System.out.println("エラー：" + deck.size() + "以下の整数値を入力してください\n処理を終了します");
				}

				Card card1 = deck.draw();
				System.out.println(card1.getMark() + "の" + card1.getNum() + "を引きました。");//カードのマークと番号を取得
				Card card2 = deck.draw();
				System.out.println(card2.getMark() + "の" + card2.getNum() + "を引きました。\n");//カードのマークと番号を取得
				deck.put(card1);
				System.out.println(card1.getMark() + "の" + card1.getNum() + "を置きました。");//カードのマークと番号を取得
				deck.put(card2);
				System.out.println(card2.getMark() + "の" + card2.getNum() + "を置きました。\n");//カードのマークと番号を取得
				card1 = deck.draw();
				System.out.println(card1.getMark() + "の" + card1.getNum() + "を引きました。");//カードのマークと番号を取得
				card2 = deck.draw();
				System.out.println(card2.getMark() + "の" + card2.getNum() + "を引きました。\n");//カードのマークと番号を取得

				third = Input.getByte("同じルールでまだ続けますか?\nEnter=続行\t1=終了");

			} while (third == 0);
			break;

		case 4:
			byte fourth;
			do {
				Deck deck = new Deck();
				deck.shuffle();
				Card card;
				Card strongest = new Card();//一番強いカード
				System.out.println("山札は現在" + deck.size() + "枚です");
				int arrayLength = Input.getInt("何枚引きますか?");
				Card[] cardArray = new Card[arrayLength];//カード型の配列を作る
				System.out.println("5枚ドローして何が一番強いか比較します");
				for (int i = 0; i < cardArray.length; i++) {//5枚ドローしてカード型の配列に入れる
					card = deck.draw();
					System.out.println(card.getMark() + "の" + card.getNum() + "を引きました。"); //カードのマークと番号を取得
					cardArray[i] = card;
				}

				for (int i = 0; i < cardArray.length; i++) {//配列長-1回繰り返し
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

				System.out.println("一番強いのは" + strongest.getMark() + "の" + strongest.getNum() + "です。");//結果

				fourth = Input.getByte("同じルールでまだ続けますか?\nEnter=続行\t1=終了");

			} while (fourth == 0);
			break;

		default:

		}

		System.out.println("お疲れさまでした！");

	}

}
