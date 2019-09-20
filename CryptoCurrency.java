import java.util.Objects;
/*
CLASS: CryptoCurrency...


      REMARKS: The cryprocurrency class store a cryptocurrency object

     -----------------------------------------
 */
public class CryptoCurrency {
    private String name;
    private String symbol;
    private int amount;
    private Blockchains chain;

    public CryptoCurrency(String name, String symbol, int amount) {
        this.name = name;
        this.symbol = symbol;
        this.amount = amount;
        chain = new Blockchains();
    }

    @Override
    public String toString() {
        return "CryptoCurrency:" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", available Unit =" + amount +
                " ";
    }

    @Override

    /*
    equals method
    PURPOSE :the equals method is to check if if the symbol of the cryhptocurrency is equals to the calling methods symbol
    if the calling method is a cryptocurrency or else if its a String then it should check if the calling method's symbol is equal to the string

    PARAMETERS: the method takes in an object
    Return  : the method return a boolean if the object is equal to the calling object
     */
    public boolean equals(Object curr) {
        boolean ret = false;

        if (curr instanceof CryptoCurrency) {
            CryptoCurrency new_curr = (CryptoCurrency) curr;
            if ( new_curr.symbol.equals(this.symbol)) {
                ret = true;
            }
        } else if (curr instanceof String) {
            String h = (String) curr;
            ret = this.symbol.equals(h);
        }
        return ret;
    }

    public Blockchains getChain() {
        return chain;
    }

    /*********************************************************************
     *  adTdochain
     * PURPOSE:The method takes in a transaction and adds it to the cryptocurrencies block chain
     * PARARMETER : The method takes in a transaction
     * RETURN : void
     *
     *********************************************************************/

    public void addToChain(Transaction transaction) {
        //chain.insert(new Mine(new Investors("debby", "D1", 100), new CryptoCurrency("crpto", "CYT", 100), 23));
        chain.insert(transaction);
    }


    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    /*********************************************************************
     *  cryptoReport
     * PURPOSE:The method prints out a cryptocurrency information in the toSTRING and the blockchain of thecrptocureny:
     *          It also verify that  the block chain has not been altered.
     * PARARMETER : No parameter
     * RETURN : void
     *
     *********************************************************************/

    public void CryptoReport () {
        System.out.println(toString() + " :" + "\n\t" +  chain.toString());
        if (!chain.compareHash()){
            System.out.println("A Block has been altered !!");
        }
        else {
            System.out.println("The Block chain is  ok ");
        }

    }
    public int hash (){
        return Objects.hash(symbol);
    }


    public String getSymbol() {
        return symbol;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
