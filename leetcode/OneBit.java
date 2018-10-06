class OneBit {
   
    //Different approach
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        
        
        if(n== 1) {
            return true;
        } else if (bits[n - 2] == 0) {
            //Two consecutive 0's mean, last is oneBit. format 00.
            return true;
        } else if(bits[n - 2] == 1) {
            //Format 110
            int j = n - 3;
            int count = 1;
            
            while(j >= 0) {
                if(bits[j] == 1) {
                    count ++;
                    j --;
                } else {
                    break;
                }
            }
            if(count % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    
    //Prettier solution with same technique as 1. Smarter
    public boolean isOneBitCharacter2(int[] bits) {
        int len = bits.length;
        int i = 0;
        
        while(i < len-1) {
            if(bits[i] == 0) {
                i ++;
            } else {
                i += 2;
            }
        }
        return i == (len - 1);
    }
    
    public boolean isOneBitCharacter1(int[] bits) {
        int len = bits.length;
        int i = 0;
        
        while(i < len) {
            if(bits[i] == 1) {
                //Read the next character as well.
                i = i+2;
                if(i == len) { return false;}
            }  else {
                i++;
                if(i == len) {return true;}
            }
            
        }
        return true;
    }

}
