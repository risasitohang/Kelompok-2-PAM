package s.develops.asalma_pam_02.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;



import java.util.List;

import s.develops.asalma_pam_02.entity.Account;

public class AccountAdapter extends ArrayAdapter<Account> {
    public  AccountAdapter(@NonNull Context context, int resource, @NonNull List<Account> objects){
        super(context, resource, objects);
    }
}
