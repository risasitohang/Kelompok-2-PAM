package s.develops.asalma_pam_02.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import s.develops.asalma_pam_02.entity.Account;

public class AccountResult {
    @SerializedName("account")
    @Expose
    private List<Account> account;

    public List<Account> getAcc(){
        return account;
    }
}
