
/*
CLASS: Trade ...

      Author: Stanley Anamelechi , 7819079

      REMARKS: What is the purpose of this class?

     -----------------------------------------
 */


/*CLASS: Trade ...


 REMARKS: The trade class  simulates a trdae based on investors currency


-----------------------------------------
*/
public class Trade extends Transaction {
    private Investors userId1;
    private Investors userId2;
    private Object currency1;
    private Object currency2;
    private int quantity1;
    private int quantity2;

    public Trade(Investors userId1, Investors userId2, Object currency1, int quantity1, Object currency2, int quantity2) {
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.quantity1 = quantity1;
        this.quantity2 = quantity2;
    }

    public Investors getUserId1() {
        return userId1;
    }

    public Investors getUserId2() {
        return userId2;
    }

    public Object getCurrency1() {
        return currency1;
    }

    public Object getCurrency2() {
        return currency2;
    }

    public int getQuantity1() {
        return quantity1;
    }

    public int getQuantity2() {
        return quantity2;
    }


    /*********************************************************************
     *  Trade
     * PURPOSE:The method is to checks if a trade is possible and performs
     *          if it is , it calss the perform trdae  doean an exchange ,
     * PARARMETER :  No parameter
     * RETURN : The method returns a string which ids the message of evry trade
     *
     *********************************************************************/

    private String Trade() {
        boolean trade = false;// check aand verifuy that a trade can be performd
        String ret = " ";
        boolean cad1 = false;//check if investor1 has CAD
        boolean cad2 = false;// check if investor2 has CAD
        boolean itrade1 = false;//checking if investor one has sufficient funds
        boolean itrdae2 = false;// checking if investor 2 has sufficient fund
        if (((userId1) != null && (userId2) != null) && (((currency1) != null && (currency2) != null))) {

            //if both traders are present and both currecnies are present
            // check if there are not the same investor
            if (!userId1.equals(userId2)) {

                //check if either of the investors has a CAD
                if (currency2 instanceof String || currency1 instanceof String) {
                    if (currency1.equals("CAD") || currency2.equals("CAD")) {
                        if (currency1.equals("CAD")) {// if the first investor has canadian dollars
                            cad1 = true;
                            // check for the quanitit
                            if (userId1.getCash() >= quantity1) {
                                itrade1 = true;
                            }
                        }
                        if (currency2.equals("CAD")) {
                            // if the second investot has canandian dollars
                            // check for the qantity
                            cad2 = true;
                            if (userId2.getCash() >= quantity2) {
                                itrdae2 = true;
                            }

                        }
                    }
                }


                // if each investor has enough cryptocurrency  have  a cryptocurrency
                if (currency1 instanceof CryptoCurrency) {// check if the currency one is a cryptocurrency
                    // then check id it is in the portfolior of thr investor

                    if ((userId1).getPort().search((CryptoCurrency) (currency1)) != null) {
                        // check if they have enough of the currency
                        if ((userId1).getPort().search((CryptoCurrency) (currency1)).getAmount() >= quantity1) {
                            // perform the trade
                            itrade1 = true;
                            // trade = true;
                        }

                    }
                }
                if (currency2 instanceof CryptoCurrency) {
                    //check if the  swcond investor has a crypocurrecnuy
                    // then check if he user has the cryptocurrency
                    if ((userId2).getPort().search((CryptoCurrency) (currency2)) != null) {
                        // if its the second investor
                        // check the quantity of the cryptocurrency
                        if ((userId2).getPort().search((CryptoCurrency) (currency2)).getAmount() >= quantity2) {
                            //trade = true;
                            itrdae2 = true;
                        }
                    }
                }


                // confimr  that aan exchange can happen if there are sufficient funds
                if (itrade1 && itrdae2) {
                    trade = true;

                } else {
                    trade = false;
                    ret = "Insufficient Funds in  Trade  ";
                }


            } else {// if there are the same investor them it should return  same investor
                ret = "Same Investor";
                trade = false;// they cant trade
            }

        }
        // if there is not one investor in the system
        else {
            trade = false;
            ret = "Not Found in Trade !";
        }


        // check and perform the  trade
        if (trade) {

            ret = "Success Trade ";
            performTrade(cad1, cad2);
        }
        return ret;
    }


    /*********************************************************************
     *  perform trade
     * PURPOSE:The method perfrom trade does an exchange of currencies  based on the currenies of the traders ,
     * PARARMETER : The method takes in a two boolean vaues checking if a currency is a CAD or not for both traders
     *              cad1 for investor 1 and cad2 for investor 2
     * RETURN : void
     *
     *********************************************************************/


    private void performTrade(boolean cad1, boolean cad2) {
        String ret = " ";
        if (cad1 && cad2) {

            // if the two inveswtors are trading canadian dollars


            // subtract the amount they have from the investors cad

            // subtract the the quantoty one of the money from inevstor 1
            assert ((userId1) != null);
            subtractFromOnvestorCash(userId1, quantity1);
            // Add the amount of  money  from investor 1 to investor2
            addtoInvestorCsh(userId2, quantity1);
            //  add the money to the second investors  cash on hand1

            // subtract the quanitity from investor2 and add it to investor 1
            assert ((userId2) != null);

            subtractFromOnvestorCash(userId2, quantity2);
            // Add the amount form investor 2 to investor 1
            addtoInvestorCsh(userId1, quantity2);

        }
        // if the two are trading CryptoCurrency
        else if (!cad1 && !cad2) {

            // subtract the quantitiy of cryptocurrency from quantity 1
            assert ((userId1) != null);
            assert ((userId2) != null);
            (userId1).subFromPortfolior((CryptoCurrency) (currency1), quantity1);
            // add the quantity to investor 2
            (userId2).addtoPortfoliior((CryptoCurrency) (currency1), quantity1);

            // subtract the quantity of crypotocurrench from the quantity 2
            (userId2).subFromPortfolior((CryptoCurrency) (currency2), quantity2);

            //add the quantituy to invetsor 1
            (userId1).addtoPortfoliior((CryptoCurrency) (currency2), quantity2);


        }

        // else if either one of the investors is trading cruptocurrency for CAd

        else if ((cad1 && !cad2) || (!cad1 && cad2)) {
            if (cad1 && !cad2) {

                /// if the investor 1 is trading cad1 for cryptocurrency
                // subtract the amount of money from invesyor one and addit to investor 2's cash
                subtractFromOnvestorCash(userId1, quantity1);
                addtoInvestorCsh(userId2, quantity1);
                // subtract the cryptocurrency from investor 2 and add it to investor 1
                (userId2).subFromPortfolior((CryptoCurrency) (currency2), quantity2);
                (userId1).addtoPortfoliior((CryptoCurrency) (currency2), quantity2);
            } else if (!cad1 && cad2) {
                // if  the investor one is trading cryptocurrency for cad
                // subtract the amount of money from investor 2 and add it ti inveator 1's cash on hand

                subtractFromOnvestorCash(userId2, quantity2);
                addtoInvestorCsh(userId1, quantity2);


                // subratct from the invetsor 1's cryptocurrency amount (quantity 1 )

                (userId1).subFromPortfolior((CryptoCurrency) (currency1), quantity1);
                // add to the investor 2's portfolior
                (userId2).addtoPortfoliior((CryptoCurrency) (currency1), quantity1);
            }
        }


    }


    /*********************************************************************
     *  search
     * PURPOSE:The method searches throughthe customerportfolir if a Investcrypto of the cryptocurrency curr has already been created ,
     *          if that object is found or returns null if not found
     *          currency is present and return the cryptocurrency and the amount ( InvestorCrypto)
     * PARARMETER : The method takes in a cryptocurrency
     * RETURN : The method returns an InvestorCrypto Object if the Cryptocurrency was found and nullif not found
     *
     *********************************************************************/


    public void addtoInvestorCsh(Investors user1, int quantity) {

        user1.setCash(user1.getCash() + quantity);
    }


    public void subtractFromOnvestorCash(Investors user1, int quantity) {
        user1.setCash(user1.getCash() - quantity);
    }

    /*********************************************************************
     *  toString
     * PURPOSE:The method searches throughthe customerportfolir if a Investcrypto of the cryptocurrency curr has already been created ,
     *          if that object is found or returns null if not found
     *          currency is present and return the cryptocurrency and the amount ( InvestorCrypto)
     * PARARMETER : No paramete
     * RETURN : The method returns an string constaing the traders and tge quantity and currencies they traded
     *
     *********************************************************************/

    @Override
    public String toString() {
        String curr1 = " ";
        String curr2 = " ";
        // check if the currency1 trader was a crptocurrency to be able to get the name
        if (currency2 instanceof CryptoCurrency) {
            curr2 = ((CryptoCurrency) currency2).getName();
        }
        // check if the currency2 trader was a crptocurrency to be able to get the name

        if (currency1 instanceof CryptoCurrency) {
            curr1 = ((CryptoCurrency) currency1).getName();
        }

        return "\tTrade:" +
                "Trader1 =" + userId1.getName() +
                ", Trader2 =" + userId2.getName() +
                ", currency1=" + curr1 +
                ", currency2=" + curr2 +
                ", quantity1=" + quantity1 +
                ", quantity2=" + quantity2 +
                '}';
    }


    /*********************************************************************
     *  callTrade
     * PURPOSE:The method calls the trade method and prints out the messages each trade gives
     *          it also adds thetrade to the  cryptocurrencies blockchains of the cryptocurrency traded if the
     *          trade was "successful""
     * PARARMETER :No parameter
     * RETURN : Void
     *
     *********************************************************************/

    public void callTrade() {
        String tradeValue = Trade();//System.out.println(Trade());
        System.out.println(tradeValue);
        // add the trade to a  the block chain of the crypto curreny block chain
        //
        if (tradeValue.equals("Success Trade ")) {

            // check if the currency is a cryptocurrency and then add to the blockchain
            // of the cryptocurrency.
            if (currency1 instanceof CryptoCurrency) {

                CryptoCurrency cryppto = (CryptoCurrency) currency1;
                cryppto.addToChain(this);
            }
            if (currency2 instanceof CryptoCurrency) {
                CryptoCurrency cryppto = (CryptoCurrency) currency2;
                cryppto.addToChain(this);
            }
        }
    }


}
