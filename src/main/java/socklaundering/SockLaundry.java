/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socklaundering;

/**
 *
 * @author austine.okoroafor
 */
public class SockLaundry {
    
  public int getMaximumPairOfSocks(int noOfWashes, int[] cleanPile, int[] dirtyPile) {

      int count = 0;
      int[] unwashed_map = new int[51];
      int[] clean_map = new int[51];

      for(int i=0;i<cleanPile.length;i++){
          clean_map[cleanPile[i]]++;
      }
      for(int i=0;i<dirtyPile.length;i++){
          unwashed_map[dirtyPile[i]]++;
      }

      for(int i=1;i<clean_map.length;i++){
          int sock = clean_map[i];
          count += sock/2;
          clean_map[i]=sock%2==0 ? 0: 1;
      }

      for(int i=1;i<clean_map.length;i++){
          if(noOfWashes==0) break;
          if(clean_map[i]>0 && unwashed_map[i]>0){
              count++;
              unwashed_map[i]-=1;
              noOfWashes--;
          }
      }

      for(int i=1;i<unwashed_map.length;i++){
          if(noOfWashes==0) break;
          int tmp = Math.min(noOfWashes, unwashed_map[i]);
          count+=tmp/2;
          if(tmp < noOfWashes && tmp%2==1) tmp--;
          noOfWashes -= tmp;
      }

      return count;
 }

    
}
