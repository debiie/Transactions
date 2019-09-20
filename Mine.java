


/*
CLASS: Mine ...


      REMARKS: The mine class, extands  transactions and it perform a mine for a crypocurrency for an investor


     -----------------------------------------
 */
public class Mine  extends Transaction {

    private Investors investor;
    private CryptoCurrency cryptoSymbol;
    private int Quantity;

    public Mine(Investors userId, CryptoCurrency cryptoSymbol, int quantity) {
        super();
        this.investor = userId;
        this.cryptoSymbol = cryptoSymbol;
        Quantity = quantity;

    }
    /*********************************************************************
     *  toString ()
     * PURPOSE:The method  toString() prints out the informationof a mine  ,
     * PARARMETER : No parameter
     * RETURN : The method returns an  String consisting of the investors name teh currency name and the quantity mined
     *
     *********************************************************************/

    @Override
    public String toString() {
        return "\tMine:" +
                "Invetsor =" + investor.getName()+
                ", CryptoCurrency=" + cryptoSymbol.getName()+
                ", Quantity=" + Quantity +
                '}';
    }


    /*********************************************************************
     *  callMine()
     * PURPOSE:The method prints out the result of a mine if successful or not and insert the transactionin
     *          int the cryptocurrencies block chain if the mine was successul ,
     *          if that object is found or returns null if not found
     *          currency is present and return the cryptocurrency and the amount ( InvestorCrypto)
     * PARARMETER :No parameter
     * RETURN : Void
     *
     *********************************************************************/
    public void callMine() {
        String mineValue = mine();
        System.out.println(mineValue );

        // check if its successfull then it should be added to the crypo
        if ( mineValue.equals("Successful Mine ")){
            cryptoSymbol.addToChain(this);
        }
    }



    /*********************************************************************
     *  mine
     * PURPOSE:The method  takes a quantity of a crptocureency and adds it to an investors portfolior ,
     * PARARMETER : No parameters
     * RETURN : The method returns a string stating an error or a successful mine
     *
     *********************************************************************/


    public String mine() {
        boolean mine;
        String ret = " ";

        if (investor !=null && cryptoSymbol != null ) {
          //  System.out.println("This is the " + cryptoSymbol.getAmount() + "and this is the  quantity " +Quantity);
            if (cryptoSymbol.getAmount() >= Quantity) {// if theer sis sufficient fund for the mine

                // mine the currency
                mine = true;
                // put it in the block chain
                ret = "Successful Mine ";
            } else {// if there is no sufficienr fund for the mine
                mine = false;

                ret = " Insufficient funds ";
            }
        } else {
            mine = false;
            ret = "Not Found ";
        }
        // perform mine
        if (mine) {
            (investor).addtoPortfoliior((cryptoSymbol), Quantity);// add to the investors portfolior
            // the amount of the currency


            //take out the quanity mined form the cryto
            (cryptoSymbol).setAmount((cryptoSymbol).getAmount() - Quantity);
        }
        return ret;// return the message
    }



    public Investors getInvestor() {
        return investor;
    }

    public CryptoCurrency getCryptoSymbol() {
        return cryptoSymbol;
    }

    public int getQuantity() {
        return Quantity;
    }
}
