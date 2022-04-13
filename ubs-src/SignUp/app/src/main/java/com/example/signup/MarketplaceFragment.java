package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MarketplaceFragment extends Fragment {
    private Button eSend;
    private Button eRequest;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_marketplace, container, false);

        eSend = v.findViewById(R.id.button2);
        eRequest = v.findViewById(R.id.button3);

        eSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(getActivity(),SendMoney.class);
                startActivity(send);
            }
        });

        eRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent request = new Intent(getActivity(),RequestMoney.class);
                startActivity(request);
            }
        });
        return v;
    }
}
