package ir.sbu.golestan.util;

import lombok.Data;

/**
 * Created by Ali Asghar on 05/06/2017.
 */
@Data
public class PageParams {
    int page;
    int size;
    String dir;
    String sortBy;

    public PageParams(int page, int size, String sortBy, String dir) {
        this.page = page;
        this.size = size;
        this.dir = dir;
        this.sortBy = sortBy;
    }

    public String toString(){
        return "Page params:" +page + "," + size + "," + dir + "," + sortBy;
    }
}
