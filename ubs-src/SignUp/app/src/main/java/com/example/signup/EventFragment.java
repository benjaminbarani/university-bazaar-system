package com.example.signup;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class EventFragment extends Fragment {

    private TextInputLayout textInputLayout;
    private AutoCompleteTextView dropDownText;
    private Button pButton;
    private TextInputEditText dInput;
    private TextInputEditText tInput;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_event, container, false);

        textInputLayout = v.findViewById(R.id.typeInput);
        pButton = v.findViewById(R.id.postButton);
        tInput = v.findViewById(R.id.titleInput);
        dInput = v.findViewById(R.id.descriptionInput);
        dropDownText = v.findViewById(R.id.dropdown_text);
        String[] items = new String[]{"Listing", "Event"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.dropdown_item, items);
        dropDownText.setAdapter(adapter);
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Homepage.BazaarList.add(new BazaarItem(tInput.getText().toString(),dInput.getText().toString(),dropDownText.getText().toString()));
                Fragment Redirect = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, Redirect);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return v;
    }
}
