
/*CLASS: Market...


 REMARKS: The market class is to process an an array of string. Based on the first inout string it performs certain command and
            The market class is to store all the list of investors created in the investorList and
           crptocurencies created  in the crryptocureency list. it  inserts cryptocurrencies and investor

-----------------------------------------
*/
public class Market {
    private InvestorList port; //= new InvestorList();
    private CryptoList crypto;// = new CryptoList();

    public Market() {
        port = new InvestorList();
        crypto = new CryptoList();

    }

    public InvestorList getPort() {
        return this.port;
    }


    public CryptoList getCrypto() {
        return crypto;
    }


    public void ProcessFile(String[] input ) {
        if (input[0].equals("NEW")) {
            this.port.insert(new Investors(input[1] + input[2], input[3], Integer.valueOf(input[4])));
        }
        if (input[0].equals("REPORT")) {
             if ( this.port.getInvestor(input[1])!=null ) {
                 this.port.getInvestor(input[1]).portfoliorReport();
             }
             else {
                 System.out.println(" Investor not found ");
             }
        }
        if (input[0].equals("CRYPTO")) {
            crypto.insert(new CryptoCurrency(input[1], input[2],Integer .valueOf( input[3])));
        }
        if (input[0].equals("MINE")) {
            Mine m1 = new Mine(searchmarketPort(input[1]), searchmarketCrypto(input[2]), Integer.valueOf(input[3]));
            m1.callMine();
        }
        if (input[0].equals("TRADE")) {
            Object input1 ;
            Object input2;
            // check if the currency to be tradeed is a crypo=to =currency or  CAD
             if (input[3] .equals("CAD")){
                 input1 = input[3];
             }

              // if the curerency of thr first trader is a cryptocurrency then it should search through the list of cryptocurrencies  in the market
             // which retuns a crypto currency or  null
             else {
                 input1= searchmarketCrypto(input[3]);
             }


             // check if the  trader 2 has a cryptocurerncy or  not
             if ( input[5].equals("CAD")){
                 input2 = input[5];
             }

             // if the currency of the trader 2 is  a cryptocurrency then it should search tr=hrought he list of crptocurrenies in the market
             // and rerurn it
             else {
                input2 = searchmarketCrypto(input[5]);
             }
             // trade  two investors and thger respective currencies with the quantity
            Trade trade  = new Trade(searchmarketPort(input[1]), searchmarketPort(input[2]), input1, Integer.valueOf(input[4]), input2, Integer.valueOf(input[6]));
            trade .callTrade();


        }

        // check if the input commadnd is a
        if ( input[0].equals("CRYPORT")){
            if ( crypto.getCrpto(input[1])!=null ) {
               //

                crypto.getCrpto(input[1]).CryptoReport();
            }
            else {
                System.out.println("Not Found");
            }
        }
        if ( input [0].equals("#")){
            int i = 1;
            String ret = " ";
            while( i < input.length) {
                ret +=input[i];
                ret += " ";
                i++;
            }
            System.out.println("#" + ret);


        }

    }

    /*
    searchmarketPort
    PURPOSE : the method searchmerketPort is to take in an investors ID and search through the LIst of investors  in the market(port )
                and return the investor  if found or null if not found
    PARARMETER : A string ID (investor ID )
    RETURN : An Investor if found and  null if not found
     */
    public Investors searchmarketPort (String Id ){
         Investors ret = null;
        if ( port.searchInvestor(Id)!=null ){
            ret = port.getInvestor(Id) ;

        }
         return ret ;
    }

    /*
    searchmarketCrypto
    PURPOSE :The method searchmarketCrupto is to a take cryptocurrency symbol and check if its in the list of CRyptocurrencies
            in the market.
    PARAMETER:A string symbol ( Cryptocurrency symbol
    RETURN : A cryptocurrency if the found in list of cryptocurrencies in the market or null if not found
     */
    public CryptoCurrency searchmarketCrypto( String symbol ){
        CryptoCurrency ret = null ;
        if ( crypto.getCrpto(symbol)!=null){
            ret = crypto.getCrpto(symbol) ;

        }
        return ret ;
    }

}
