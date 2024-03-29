package tramp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	String[] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K","Joker"};
	String[] marks = {"スペード","ハート","ダイヤ","クローバー"};

	private List<Card> cards;//カードリストをカプセル化して所持


	//コンストラクタ
	public Deck() {
		cards= new ArrayList<Card>();//カード型のリスト(空の箱を作成)
		for(int i=0;i<52;i++) {//カード型のインスタンスを52枚生成して
			cards.add(new Card());//リストにカードを追加
		}

		for(int i=0;i<marks.length;i++) {//カード型のインスタンスに52個の値をセットする
			for(int j=0;j<numbers.length-1;j++) {//番号を13回ループ
				Card card=new Card(marks[i],numbers[j]);//各配列に従って値をセット(52個)
				cards.set(i*13+j,card);
			}
		}
		cards.add(new Card("赤",numbers[13]));//ジョーカーを2枚作ってリストに追加する
		cards.add(new Card("黒",numbers[13]));


	}
	public void shuffle() {
		Collections.shuffle(cards);//山札をシャッフルする
	}


	public Card draw() {
		int no = cards.size()-1;//山札の一番下を引く
		Card card=cards.get(no);//インデックスがnoの要素を取得してカード型変数に代入
		cards.remove(no);//インデックスがnoの要素を削除
		return card;//カードを返す
	}
	public String size() {
		return (cards.size()+"枚");
	}


}
