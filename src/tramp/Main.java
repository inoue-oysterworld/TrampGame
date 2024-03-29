package tramp;

import lib.Input;

public class Main {

	public static void main(String[] args) {
		Deck deck=new Deck();
		deck.shuffle();
		System.out.println("山札は現在"+deck.size());//デバッグ用

		int count=Input.getInt("何枚引きますか?");//ドローフォームを表示
		if(count!=0) {//有効値判定

			for(int i=0;i<count;i++) {
				Card card=deck.draw();//カードを1枚引く
				System.out.println(card.getMark()+"の"+card.getNumber()+"を引きました。");//カードのマークと番号を取得
			}

		}else {
			System.out.println("エラー：0以上の整数値を入力してください\n処理を終了します");
		}

	}

}
