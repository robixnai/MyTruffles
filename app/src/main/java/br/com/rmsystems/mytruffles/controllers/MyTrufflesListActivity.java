package br.com.rmsystems.mytruffles.controllers;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.rmsystems.mytruffles.R;
import br.com.rmsystems.mytruffles.adapters.MyTruffleAdapter;
import br.com.rmsystems.mytruffles.models.Order;
import br.com.rmsystems.mytruffles.models.Truffle;
import br.com.rmsystems.mytruffles.utils.AppUtil;

public class MyTrufflesListActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD = 1;
    private RecyclerView mMyTruffles;
    private MyTruffleAdapter mMyTruffleAdapter;
    private Menu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_truffles_list);

        this.bindElements();

        super.registerForContextMenu(mMyTruffles);
    }

    private void bindElements() {
        mMyTruffles = AppUtil.get(findViewById(R.id.recyclerViewServiceOrders));
        mMyTruffles.setHasFixedSize(true);
        mMyTruffles.setLayoutManager(new LinearLayoutManager(this));

        final FloatingActionButton fabAdd = AppUtil.get(findViewById(R.id.fabCar));
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddOrderClick(view);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final List<Truffle> serviceOrders = Truffle.getAll();
        if (mMyTruffleAdapter == null) {
            mMyTruffleAdapter = new MyTruffleAdapter(serviceOrders);
            mMyTruffles.setAdapter(mMyTruffleAdapter);
        } else {
            mMyTruffleAdapter.setItens(serviceOrders);
            mMyTruffleAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_my_truffles_list_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private List<Truffle> getTruffles() {
        final List<Truffle> truffles = new ArrayList();

        for (final Truffle truffle : mMyTruffleAdapter.getItens()) {
            if (truffle.getQuantity() != null && truffle.getQuantity() > 0) {
                truffles.add(truffle);
            }
        }

        return truffles;
    }

    private void AddOrderClick(View v) {
        final List<Truffle> truffles = getTruffles();
        final Order order = new Order();

        if (truffles.size() == 0) {
            Toast.makeText(MyTrufflesListActivity.this, "Você não selecionou nenhuma quatidade seu idiota.", Toast.LENGTH_SHORT).show();
        } else {
            order.setTruffle(truffles);

            /*final PopupMenu popup = new PopupMenu(MyTrufflesListActivity.this, v);
            popup.inflate(R.menu.menu_my_truffles_list_actionbar);
            popup.show();
            final Intent goToAddActivity = new Intent(MyTrufflesListActivity.this, MyTruffleActivity.class);
            startActivity(goToAddActivity);*/
            this.CarrDialog();
        }
    }

    private void CarrDialog() {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.dialog_car);

        //define o título do Dialog
        dialog.setTitle("Fechar pedido");

        //bind os objetos que estão no layout dialog_car.xml

        /*confirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etRetorno.setText(editText.getText());

                //finaliza o dialog
                dialog.dismiss();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //finaliza o dialog
                dialog.dismiss();
            }
        });*/

        //exibe na tela o dialog
        dialog.show();
    }

}
