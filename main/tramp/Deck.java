package tramp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
	String[] marks = { "スペード", "ハート", "ダイヤ", "クローバー", "赤", "黒" };

	private List<Card> cards;//カードリストをカプセル化して所持

	//コンストラクタ
	public Deck() {
		cards = new ArrayList<Card>();//カード型のリスト(空の箱を作成)
		for (int i = 0; i < 52; i++) {//カード型のインスタンスを52枚生成して
			cards.add(new Card());//リストにカードを追加
		}

		for (int i = 0; i < marks.length - 2; i++) {//カード型のインスタンスに52個の値をセットする
			for (int j = 0; j < numbers.length - 1; j++) {//番号を13回ループ
				Card card = new Card(marks[i], numbers[j]);//各配列に従って値をセット(52個)
				cards.set(i * 13 + j, card);
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

	public boolean drawable() {//ドロー可能判定(nullを返せという課題があるが、なかなか簡潔に書ける方法が思いつかない)
		boolean bool;
		if (cards.size() > 0) {
			bool = true;
		} else {
			bool = false;
		}
		return bool;
	}

	public Card draw() {//ドロー動作
		if (cards.size() == 0) {//デッキが0枚だったらnullを返す
			Card card = null;
			return card;
		}

		int no = cards.size() - 1;//山札の一番下を引く
		Card card = cards.get(no);//インデックスがnoの要素を取得してカード型変数に代入
		cards.remove(no);//インデックスがnoの要素を削除
		return card;//カードを返す
	}

	public void put(Card card) {
		cards.add(card);
	}

}
