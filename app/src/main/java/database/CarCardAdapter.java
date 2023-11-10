package database;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mersbens.AboutCarActivity;
import com.example.mersbens.R;

import java.util.List;

public class CarCardAdapter extends  RecyclerView.Adapter<CarCardAdapter.CarCardViewHolder> {

	List<Car> carsList;
	Context context;

	public CarCardAdapter(List<Car> cars, Context context) {
		this.context = context;
		this.carsList = cars;
	}

	class CarCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		public TextView titleTextView, transmissionTextView, doorsTextView, maxSpeedTextView, tankTextView;
		public ImageView imageViewCar;

		public CarCardViewHolder(View itemView) {
			super(itemView);
			itemView.setOnClickListener(this);
			titleTextView = itemView.findViewById(R.id.textViewItemSportCar);
			transmissionTextView = itemView.findViewById(R.id.textViewTransmission);
			doorsTextView = itemView.findViewById(R.id.textViewDoor);
			maxSpeedTextView = itemView.findViewById(R.id.textViewSpeed);
			tankTextView = itemView.findViewById(R.id.textViewTank);
			imageViewCar = itemView.findViewById(R.id.imageViewCar);
		}

		@Override
		public void onClick(View v) {
			int position = getAdapterPosition();
			int id = carsList.get(position).getId();
			Intent intent = new Intent(context, AboutCarActivity.class);
			intent.putExtra("idCar", id);
			context.startActivity(intent);
		}
	}

	@Override
	public CarCardAdapter.CarCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
			.inflate(R.layout.item_car_leyout, parent, false);

		CarCardViewHolder carCardViewHolder = new CarCardViewHolder(view);
		return carCardViewHolder;
	}

	@Override
	public void onBindViewHolder(CarCardViewHolder holder, int position) {
		Car car = carsList.get(position);
		holder.titleTextView.setText(car.getModel());
		holder.transmissionTextView.setText(car.getTypeTransmission());
		holder.doorsTextView.setText(car.getCountDoorsAndPlaces());
		holder.maxSpeedTextView.setText(car.getMaxSpeed());
		holder.tankTextView.setText(car.getFuelTankCapacity());
		holder.imageViewCar.setImageResource(car.getImagePath());
	}

	@Override
	public int getItemCount() {
		return carsList.size();
	}
}
