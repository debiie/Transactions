
/*
CLASS: BlockChain ...


      REMARKS: The blockchain class  stores a list of all transactions for a cryptocurrecny

     -----------------------------------------
 */
public class Blockchains {
    private LinkedList allblocks;
    private LinkedList hashlist;

    public Blockchains() {
        allblocks = new LinkedList();
        hashlist = new LinkedList();
    }

    @Override
    public String toString() {
        return "Blockchain { " +
                "" + allblocks.print() +
                '}';
    }

    public LinkedList getAllblocks() {
        return allblocks;
    }

    public LinkedList getHashlist() {
        return hashlist;
    }


    /*********************************************************************
     *  insert
     * PURPOSE:The method inserts a transaction into the blockchain, and the hash of that block int a list
     * PARARMETER : The method takes in a transaction
     * RETURN : Void
     *
     *********************************************************************/

    public void insert(Transaction transction) {

        if (allblocks.isEmpty()) {
            // if the list is empty then put in the first transaction
            //Block newBlock  = new Block(transction, 0 );
            Block newBlock = new Block(transction, 0);
            newBlock = newBlock.firstBlock(transction);
            allblocks.insert(newBlock);
            hashlist.insert(newBlock.getHash());
        } else {

            if (allblocks.getLast() != null) {
                Block block = (Block) allblocks.getLast();
                // inserting a next block to the block chain from the last block hash code
                Block nextBlock = block.nextBlock(transction);

                allblocks.insertToEnd(nextBlock);
                hashlist.insertToEnd(nextBlock.getHash());
            }
        }
    }

    /*********************************************************************
     *  compareHash
     * PURPOSE:The method takes the list that has all the hash code of each block created  and compares it with the hash code in the block ,
     * PARARMETER : No parametr
     * RETURN : The method return sa boolean if the hash code inthe block chain is the same as the hash  code in
     *          the list cntainng all the hash code initialy computed
     *
     *********************************************************************/

    public boolean compareHash() {
        return allblocks.compare(hashlist);

    }

}
