package lk.avalanche.timer.ui.main;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import lk.avalanche.timer.R;
import lk.avalanche.timer.ui.main.SoundFragment.OnListFragmentInteractionListener;
import lk.avalanche.timer.ListContent.SoundContent.SoundItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SoundItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SoundRecyclerViewAdapter extends RecyclerView.Adapter<SoundRecyclerViewAdapter.ViewHolder> {

    private final List<SoundItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public SoundRecyclerViewAdapter(List<SoundItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_sound, parent, false);
        return new ViewHolder(view);
    }

    ViewHolder lastSelected = null;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked(position, holder);
            }
        });
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onViewClicked(position, holder);
            }
        });
    }

    void onViewClicked(int position, ViewHolder holder) {
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            if (lastSelected != null) lastSelected.mRadioButton.setChecked(false);
            holder.mRadioButton.setChecked(true);
            mListener.onListFragmentInteraction(holder.mItem);
            lastSelected = holder;
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final RadioButton mRadioButton;
        public SoundItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.txtSoundName);
            mRadioButton = (RadioButton) view.findViewById(R.id.radioBtn);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mRadioButton.getText() + "'";
        }
    }
}
