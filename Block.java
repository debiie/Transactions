
import java.util.Objects;


/*
CLASS: Block ...


      REMARKS: What is the purpose of this class?

     -----------------------------------------
 */
public class Block {
    private Transaction trans;
    public int hash;
    private int previousHash;
    public Block(Transaction trans, int previousHash ) {
        this.trans = trans;
        this.previousHash = previousHash;
        this.hash = hash();

    }

    public Transaction getTrans() {
        return trans;
    }

     /*
    getHash() Method
    PURPOSE : Return the hash  code of a Block
    PARAMETER: No paraeter
    RETURN : int ( Hash Code )
     */

    public int getHash() {
        return hash();
    }




    /*********************************************************************
     *  hash
     *
     * PURPOSE: To  compute the hash of a block:
     *    - Take in a previous hash code and compute t=a new hash code (code )
     *      using the transactions fileds and the previous hash
     *
     * PARAMETER : the method takes in a hash code ( previous hash ) the hash of the last blck
     *
     * RETURN :  the method returns the computed hash code of
     *********************************************************************/
    private    int hash() {
        int code = 0;
        if (trans instanceof Mine) {
            Mine mine  = (Mine) trans;
            //cast transcation object as a mine
            // get the hash code of the mine objects name , the cryptocurrency symol in  and the quantity that was mmined
            code = Objects.hash(mine.getInvestor().getName(), mine.getCryptoSymbol().getSymbol(), mine .getQuantity(), previousHash);
            //
        } else if (trans instanceof Trade) {
            // if the transactionis a trade , it would give diffeent hash codes depending on
            Trade trade = (Trade) trans;
            CryptoCurrency c1 = null;
            CryptoCurrency c2 = null;


            // is crypto is to check if the first investor in the trade has a cryptocurrency to determine what would be hashed
            boolean isCrypto= false ;
            // isCrypto2 is to check if the seconf=d investor  was  trading a cryptocurrency
            boolean isCrypto2 = false;


            // check if the investor 1 in trade has a crypoto currency
            if (trade.getCurrency1() instanceof CryptoCurrency) {
                c1 = (CryptoCurrency) trade.getCurrency1();
                isCrypto= true ;
            }

            // if the investor 2 has a crypto currency
            if (trade.getCurrency2() instanceof CryptoCurrency) {
                c2 = (CryptoCurrency) trade.getCurrency2();
                isCrypto2 = true ;
            }


            // if they both have a cryptocurrency: get the hash code of the trade ( cryptocurrency's cymbol )
            if ( c1 != null && c2 != null ) {

                code = Objects.hash(trade.getUserId1().getName(), trade.getUserId2().getName(), c1.getSymbol(), c2.getSymbol(), trade.getQuantity1(), trade.getQuantity2(), previousHash);

            }

            /// check if either one of the traders was trading using CAD


            /// check if the first trader used  cryptocurrency and second trader didnt

            else if (isCrypto &&  !isCrypto2){
                // c
                code = Objects.hash ( trade.getUserId1().getName(), trade.getUserId2().getName(),c1.getSymbol(),trade.getCurrency2(),trade.getQuantity2(),previousHash);

            }
            // check if the second trader was trading cryptocurrency and the first trader was not
            else if ( !isCrypto&&isCrypto2){
                code = Objects.hash ( trade.getUserId1().getName(), trade.getUserId2().getName(),trade.getCurrency1(),c2.getSymbol(),trade.getQuantity2(),previousHash);

            }
            // or check if they both didnt trade cryptocurrency

            else if (!isCrypto && !isCrypto2){
                code = Objects.hash ( trade.getUserId1().getName(), trade.getUserId2().getName(),trade.getCurrency1(),trade.getCurrency2(),trade.getQuantity2(),previousHash);


            }
        }
        return code;
    }


    public Block firstBlock (Transaction trans ){
        Block ret = new Block (trans,0 );
        ret.hash= 0 ;
        return ret ;
    }

    /*********************************************************************
     *  nextBlock
     *
     * PURPOSE: To return a new block and a hash code :
     *    - the hash code of the new block is computed using the hash method ,and the previous
     *    hash is  the calling methods(the previous block) hash code
     * PARARMETER : The method takes in a transaction
     * RETURN : The method returns a new block with a new Transaction and hash
     *          code ( the hash of the tansaction and the previous hash from a previous block )
     *
     *********************************************************************/

    public Block nextBlock(Transaction transaction) {
        Block ret;
        ret = new Block(transaction, this.getHash());
        return ret;

    }



    /*********************************************************************
     *  toString()
     *
     * PURPOSE: To return a String that contains the each transactions :
     *    - the hash code of the new block is computed using the hash method ,and the previous
     *    hash is  the calling methods(the previous block) hash code
     * PARARMETER : No pararmeter
     * RETURN : The method is to a  the tstring conatining the transaction of the block
     *
     *********************************************************************/


    @Override
    public String toString() {
        return "" +
                "\t\n" + trans.toString()
                ;
    }

    /*********************************************************************
     *  equals()
     *
     * PURPOSE: The equals method is to take an object and comparet it with the hash code of the block,
     *         - if the object val is an integer
     *
     * PARARMETER : The method takes in an object val
     * RETURN : The method returns a new block with a new Transaction and hash
     *          code ( the hash of the tansaction and the previous hash from a previous block )
     *
     *********************************************************************/

    public boolean equals(Object val) {
        Integer othercode = -1;
        if (val instanceof Integer) {
            othercode = (Integer) val;
        }



        return getHash() == othercode;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + hash ;
    }
}
