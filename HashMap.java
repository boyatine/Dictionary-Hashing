import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HashMap {
    final int NUM_HASH = 22; // total number of hash functions
    // if adding more hash functions, update above number and switch statements in put and lookUp
    List<Integer> hashOrder = new ArrayList<>();

    String[] table;
    int tableSize;

    int misspelledCount = 0;
    int collisions = 0;

    /* Constructor */
    HashMap(int entries) {
        tableSize = entries * 2;
        while (!isPrime(tableSize))
            tableSize++;

        table = new String[tableSize];

        /* Hash function randomize */
        for (int i = 1; i <= NUM_HASH; i++)
            hashOrder.add(i);
        Collections.shuffle(hashOrder);
    }

    /* Prime checker */
    private Boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if ((x % i) == 0)
                return true;
        }
        return false;
    }

    /* Hash & insert elements */
    public void put(String elem) {
        int funcNum;
        Boolean inserted = false;
        int i = 0;

        while (!inserted && i < NUM_HASH) {
            funcNum = hashOrder.get(i);
            switch (funcNum) {
                case 1:
                    inserted = hash1(elem);
                    break;
                case 2:
                    inserted = hash2(elem);
                    break;
                case 3:
                    inserted = hash3(elem);
                    break;
                case 4:
                    inserted = hash4(elem);
                    break;
                case 5:
                    inserted = hash5(elem);
                    break;
                case 6:
                    inserted = hash6(elem);
                    break;
                case 7:
                    inserted = hash7(elem);
                    break;
                case 8:
                    inserted = hash8(elem);
                    break;
                case 9:
                    inserted = hash9(elem);
                    break;
                case 10:
                    inserted = hash10(elem);
                    break;
                case 11:
                    inserted = hash11(elem);
                    break;
                case 12:
                    inserted = hash12(elem);
                    break;
                case 13:
                    inserted = hash13(elem);
                    break;
                case 14:
                    inserted = hash14(elem);
                    break;
                case 15:
                    inserted = hash15(elem);
                    break;
                case 16:
                    inserted = hash16(elem);
                    break;
                case 17:
                    inserted = hash17(elem);
                    break;
                case 18:
                    inserted = hash18(elem);
                    break;
                case 19:
                    inserted = hash19(elem);
                    break;
                case 20:
                    inserted = hash20(elem);
                    break;
                case 21:
                    inserted = hash21(elem);
                    break;
                case 22:
                    inserted = hash22(elem);
                    break;
            }
            i++;
        }

        // The below portion should not execute if our hash is perfect
//        if (inserted == false) {
//            collisions++;
//            System.out.println(elem + " - Could not hash with current hash functions.");
//        }
    }

    /* Hash & look up element */
    public Boolean lookUp(String elem) {
        int funcNum;
        Boolean found = false;
        int i = 0;
        
        elem = elem.toLowerCase();

        while (!found && i < NUM_HASH) {
            funcNum = hashOrder.get(i);
            switch (funcNum) {
                case 1:
                    found = _hash1(elem);
                    break;
                case 2:
                    found = _hash2(elem);
                    break;
                case 3:
                    found = _hash3(elem);
                    break;
                case 4:
                    found = _hash4(elem);
                    break;
                case 5:
                    found = _hash5(elem);
                    break;
                case 6:
                    found = _hash6(elem);
                    break;
                case 7:
                    found = _hash7(elem);
                    break;
                case 8:
                    found = _hash8(elem);
                    break;
                case 9:
                    found = _hash9(elem);
                    break;
                case 10:
                    found = _hash10(elem);
                    break;
                case 11:
                    found = _hash11(elem);
                    break;
                case 12:
                    found = _hash12(elem);
                    break;
                case 13:
                    found = _hash13(elem);
                    break;
                case 14:
                    found = _hash14(elem);
                    break;
                case 15:
                    found = _hash15(elem);
                    break;
                case 16:
                    found = _hash16(elem);
                    break;
                case 17:
                    found = _hash17(elem);
                    break;
                case 18:
                    found = _hash18(elem);
                    break;
                case 19:
                    found = _hash19(elem);
                    break;
                case 20:
                    found = _hash20(elem);
                    break;
                case 21:
                    found = _hash21(elem);
                    break;
                case 22:
                    found = _hash22(elem);
                    break;
            }
            i++;
        }

        if (!found) {
            misspelledCount++;
        }

        return found;
    }

    public String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    /********** HASH FUNCTIONS ***********/
    // Each hash function has a matching _function
    // corresponding to inserting hash and searching hash.
    private Boolean hash1(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash1(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash2(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 41 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash2(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 41 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 41 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash3(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 61 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash3(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 61 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 61 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash4(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 59209 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash4(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 59209 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 59209 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash5(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 101 * hashVal + ch * 7;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash5(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 101 * hashVal + ch * 7;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 101 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash6(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 88661 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash6(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 88661 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 88661 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash7(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 65599 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash7(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 65599 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 65599 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash8(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 73 * hashVal + ch * 19 - 31 * hashVal;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash8(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 73 * hashVal + ch * 19 - 31 * hashVal;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 73 * hashVal + ch * 19 - 31 * hashVal;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash9(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 83 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash9(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 83 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 83 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash10(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 89 * hashVal + ch * 11 + hashVal / 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash10(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 89 * hashVal + ch * 11 + hashVal / 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 89 * hashVal + ch * 11 + hashVal / 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash11(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 33 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash11(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 33 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 33 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash12(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = (53 * hashVal + ch) / 67;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash12(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = (53 * hashVal + ch) / 67;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = (53 * hashVal + ch) / 67;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash13(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash13(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash14(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = ch + (hashVal << 6) + (hashVal << 16) - hashVal;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash14(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = ch + (hashVal << 6) + (hashVal << 16) - hashVal;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = ch + (hashVal << 6) + (hashVal << 16) - hashVal;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash15(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash15(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash16(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 59;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash16(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 59;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 59;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash17(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 29;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash17(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 29;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 31 * hashVal + ch * 29;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash18(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch * 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash18(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch * 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch * 31;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash19(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch * 83;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash19(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch * 83;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 37 * hashVal + ch * 83;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash20(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 23 * hashVal + ch * 67;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash20(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 23 * hashVal + ch * 67;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 23 * hashVal + ch * 67;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash21(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 47 * hashVal + ch * 109;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash21(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 47 * hashVal + ch * 109;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 47 * hashVal + ch * 109;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    private Boolean hash22(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 29 * hashVal + ch * 503;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] == null) {
            table[hashVal] = elem;
            return true;
        }
        else
            return false;
    }

    private Boolean _hash22(String elem) {
        int hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 29 * hashVal + ch * 503;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        elem = capitalizeFirstLetter(elem);
        hashVal = 0;

        for (char ch: elem.toCharArray())
            hashVal = 29 * hashVal + ch * 503;
        hashVal = Math.abs(hashVal) % tableSize;

        if (table[hashVal] != null
                && table[hashVal].equals(elem))
            return true;

        return false;
    }

    /* Main driver */
    public static void main(String[] args) {
        File dictionary = new File(args[0]);
        File inputFile = new File(args[1]);
        BufferedReader reader;
        String[] words;
        String text;

        try {
            /* dictionary */
            reader = new BufferedReader(new FileReader(dictionary));

            // Count # of lines in dictionary
            LineNumberReader count = new LineNumberReader(reader);

            // Loop in case input file is > Long.MAX_VALUE
            while (count.skip(Long.MAX_VALUE) > 0) {
            }
            int result = count.getLineNumber() + 1;

            reader = new BufferedReader(new FileReader(dictionary));

            long createStart = System.nanoTime();   // create timer START

            HashMap hashMap = new HashMap(result);
            while ((text = reader.readLine()) != null )
                hashMap.put(text);

            long createEnd = System.nanoTime();     // create timer END

            reader.close();

            /* spell check */
            reader = new BufferedReader(new FileReader(inputFile));

            long checkStart = System.nanoTime();    // check timer START

            while ((text = reader.readLine()) != null ) {
                words = text.split("\\W+");
                for (int i = 0; i < Array.getLength(words); i++)
                    if (!words[i].equals(""))
                        hashMap.lookUp(words[i]);
            }

            long checkEnd = System.nanoTime();      // check timer END

            reader.close();
            System.out.println("Total number of misspelled words: " + hashMap.misspelledCount);
            System.out.println("Time to create hash (nanoseconds): " + (createEnd - createStart));
            System.out.println("Time to spell check (nanoseconds): " + (checkEnd - checkStart));
        }
        catch (IOException e) {
            System.out.println("The specified file(s) could not be opened.");
        }
    }
}