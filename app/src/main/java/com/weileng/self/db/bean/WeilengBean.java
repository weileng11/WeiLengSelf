package com.weileng.self.db.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.weileng.self.db.IOperateType;

import java.io.Serializable;

/**
 * Created by lt on 2016/3/9.
 */
@DatabaseTable(tableName = "weilengtest_table")
public class WeilengBean extends IOperateType  implements Serializable {

//    @DatabaseField(id=true,canBeNull=false) true设置代表是唯，canBeNull是指不为空
//    public int mId;
    @DatabaseField(id=true,canBeNull=false)
    public int Id;
    @DatabaseField
    public String mUserName;
    @DatabaseField
    public int mAge;
}
