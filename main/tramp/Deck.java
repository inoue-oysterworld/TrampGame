package tramp;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	String[] marks = { "スペード", "ハート", "ダイヤ", "クローバー", "赤", "黒" };

	private ArrayList<Card> cards;//カードリストをカプセル化して所持

	//コンストラクタ
	public Deck() {
		cards = new ArrayList<Card>();//カード型のリスト(空の箱を作成)
		for (int i = 0; i < marks.length - 2; i++) {//カード型のインスタンスに52個の値をセットする
			for (int j = 0; j < numbers.length - 1; j++) {//番号を13回ループ
				Card card = new Card(marks[i], numbers[j]);//各配列に従って値をセット(52個)
				cards.add(i * 13 + j, card);
			}
		}
		cards.add(new Card(marks[4], numbers[13]));//ジョーカーを2枚作ってリストに追加する
		cards.add(new Card(marks[5], numbers[13]));

	}

	public void shuffle() {
		Collections.shuffle(cards);//山札をシャッフルする
	}

	public int size() {
		return (cards.size());
	}

	public boolean drawable(int count) {//ドロー可能判定
		boolean bool;
		if (this.size() >= count) {
			bool = true;
		} else {
			bool = false;
		}
		return bool;
	}

	public Card draw() {//ドロー動作
		if (cards.size() == 0) {//デッキが0枚だったらnullを返す
			return null;
		}

		Card card = cards.get(0);//インデックスが0の要素を取得してカード型変数に代入
		cards.remove(0);//インデックスが0の要素を削除	//ここでインデックス全体が左にシフトする
		return card;//カードを返す
	}

	public void putOnTop(Card card) {//デッキの上に置く
		cards.add(0,card);
	}

	public void putDown(Card card) {//デッキの下に置く
		cards.add(card);

	}

}
