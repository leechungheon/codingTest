class Solution {
    //ext 가 val_ext 미만인 것 중에 sort_by에 따라 오름차순 정렬하기
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Product[] product = new Product[data.length];
        Product[] preSort=new Product[data.length];
        for(int i=0; i<data.length; i++){
                product[i]=new Product(data[i][0], data[i][1], data[i][2], data[i][3]);
        }
        makeArray(ext,val_ext,product,preSort);
        int count = 0;
        for (Product p : preSort) {
            if (p != null) count++;
        }
        Product[] filteredArray = new Product[count];
        int index = 0;
        for (Product p : preSort) {
            if (p != null) {
                filteredArray[index++] = p;
            }
        }
        sortArray(filteredArray, sort_by);
        int[][] answer = new int[filteredArray.length][4];
        for(int i=0; i<filteredArray.length; i++){
            answer[i][0]=filteredArray[i].code;
            answer[i][1]=filteredArray[i].date;
            answer[i][2]=filteredArray[i].maximum;
            answer[i][3]=filteredArray[i].remain;
        }

        return answer;
    }
    class Product{
        int code;
        int date;
        int maximum;
        int remain;
        public Product(int code, int date, int maximum, int remain){
            this.code=code;
            this.date=date;
            this.maximum=maximum;
            this.remain=remain;
        }
    }
    public void temp(Product[] preSort, int i){
        Product tmp;
        tmp=preSort[i];
        preSort[i]=preSort[i+1];
        preSort[i+1]=tmp;
    }
    public void makeArray(String ext, int val_ext, Product[] product, Product[] preSort){
        int cnt=0;
        if(ext.equals("code")){
            for(int i=0; i<product.length; i++){
                if(product[i].code<val_ext){
                    preSort[cnt]=product[i];
                    cnt++;
                }
            }
        }
        if(ext.equals("date")){
            for(int i=0; i<product.length; i++){
                if(product[i].date<val_ext){
                    preSort[cnt]=product[i];
                    cnt++;
                }
            }
        }
        if(ext.equals("maximum")){
            for(int i=0; i<product.length; i++){
                if(product[i].maximum<val_ext){
                    preSort[cnt]=product[i];
                    cnt++;
                }
            }
        }
        if(ext.equals("remain")){
            for(int i=0; i<product.length; i++){
                if(product[i].remain<val_ext){
                    preSort[cnt]=product[i];
                    cnt++;
                }
            }
        }
    }
    public void sortArray(Product[] preSort, String sort_by){
        if(sort_by.equals("date")){
            for(int i=0; i<preSort.length-1; i++){
                for(int j=0; j<preSort.length-1-i; j++){
                    if(preSort[j].date>preSort[j+1].date)temp(preSort, j);
                }
            }
        }
        if(sort_by.equals("code")){
            for(int i=0; i<preSort.length-1; i++){
                for(int j=0; j<preSort.length-1-i; j++){
                    if(preSort[j].code>preSort[j+1].code)temp(preSort, j);
                }
            }
        }
        if(sort_by.equals("maximum")){
            for(int i=0; i<preSort.length-1; i++){
                for(int j=0; j<preSort.length-1-i; j++){
                    if(preSort[j].maximum>preSort[j+1].maximum)temp(preSort, j);
                }
            }
        }
        if(sort_by.equals("remain")){
            for(int i=0; i<preSort.length-1; i++){
                for(int j=0; j<preSort.length-1-i; j++){
                    if(preSort[j].remain>preSort[j+1].remain)temp(preSort, j);
                }
            }
        }
    }
}