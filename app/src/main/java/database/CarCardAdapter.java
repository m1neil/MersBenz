package database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mersbens.R;

import java.util.List;

public class CarCardAdapter extends  RecyclerView.Adapter<CarCardAdapter.CarCardViewHolder> {

	List<Car> carsList;

	public CarCardAdapter(List<Car> cars) {
		this.carsList = cars;
	}

	public static class CarCardViewHolder extends RecyclerView.ViewHolder {

		public TextView titleTextView, transmissionTextView, doorsTextView, maxSpeedTextView, tankTextView;
		public ImageView imageViewCar;

		public CarCardViewHolder(View itemView) {
			super(itemView);

			titleTextView = itemView.findViewById(R.id.textViewItemSportCar);
			transmissionTextView = itemView.findViewById(R.id.textViewTransmission);
			doorsTextView = itemView.findViewById(R.id.textViewDoor);
			maxSpeedTextView = itemView.findViewById(R.id.textViewSpeed);
			tankTextView = itemView.findViewById(R.id.textViewTank);
			imageViewCar = itemView.findViewById(R.id.imageViewCar);
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
