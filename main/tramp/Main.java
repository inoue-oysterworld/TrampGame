package tramp;

import lib.Input;

public class Main {

	public static void main(String[] args) {
		System.out.println("実行する処理を選んでください");
		System.out.println("1:ただデッキを用意して適当にカードを引く\n2:デッキを用意して2枚カードを引いて強さを比較する");
		int a=Input.getInt("1～2の整数");
		System.out.println("処理を開始します\n---------------");

		switch(a) {
		case 1:
			int first;
			do {
				Deck deck=new Deck();
				deck.shuffle();
				System.out.println("山札は現在"+deck.size()+"枚です");

				int count=Input.getInt("何枚引きますか?");//ドローフォームを表示
				if(count==0) {
					System.out.println("パスします");

				}else if(deck.size()-count>=0) {//有効値判定

					for(int i=0;i<count;i++) {
						Card card=deck.draw();//カードを1枚引く
						System.out.println(card.getMark()+"の"+card.getNum()+"を引きました。");//カードのマークと番号を取得
					}

				}else{
					System.out.println("エラー："+deck.size()+"以下の整数値を入力してください\n処理を終了します");
				}

				first=Input.getInt("同じルールでまだ続けますか?\nEnter=続行\t1=終了");

			}while(first==0);

		case 2:
			int second;
			do {
				Deck deck=new Deck();
				deck.shuffle();
				System.out.println("山札は現在"+deck.size()+"枚です");
				System.out.println("2枚ドローして大小比較します");
				Card card1=deck.draw();
				System.out.println(card1.getMark()+"の"+card1.getNum()+"を引きました。");//カードのマークと番号を取得
				Card card2=deck.draw();
				System.out.println(card2.getMark()+"の"+card2.getNum()+"を引きました。");//カードのマークと番号を取得
				int compare=card1.compareTo(card2);
				if(compare>0) {
					System.out.println("前者の勝ちです");

				}else if(compare<0){
					System.out.println("後者の勝ちです");

				}else {
					System.out.println("引き分けです");
				}



				second=Input.getInt("同じルールでまだ続けますか?\nEnter=続行\t1=終了");

			}while(second==0);

		default:

		}


		System.out.println("お疲れさまでした！");

	}

}