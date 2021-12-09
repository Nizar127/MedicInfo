// Generated by view binder compiler. Do not edit!
package com.doctor.medicinfo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.doctor.medicinfo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton addPatient;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final CalendarView calendarView;

  @NonNull
  public final FrameLayout containerFragment;

  @NonNull
  public final RadioButton dayData;

  @NonNull
  public final RecyclerView homeRecycler;

  @NonNull
  public final RadioButton monthData;

  @NonNull
  public final RadioGroup rgTask;

  @NonNull
  public final LinearLayout themainrecycle;

  @NonNull
  public final View vSep1;

  @NonNull
  public final View vSep2;

  @NonNull
  public final RadioButton weekData;

  private ActivityHomeBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton addPatient, @NonNull BottomNavigationView bottomNavigation,
      @NonNull CalendarView calendarView, @NonNull FrameLayout containerFragment,
      @NonNull RadioButton dayData, @NonNull RecyclerView homeRecycler,
      @NonNull RadioButton monthData, @NonNull RadioGroup rgTask,
      @NonNull LinearLayout themainrecycle, @NonNull View vSep1, @NonNull View vSep2,
      @NonNull RadioButton weekData) {
    this.rootView = rootView;
    this.addPatient = addPatient;
    this.bottomNavigation = bottomNavigation;
    this.calendarView = calendarView;
    this.containerFragment = containerFragment;
    this.dayData = dayData;
    this.homeRecycler = homeRecycler;
    this.monthData = monthData;
    this.rgTask = rgTask;
    this.themainrecycle = themainrecycle;
    this.vSep1 = vSep1;
    this.vSep2 = vSep2;
    this.weekData = weekData;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addPatient;
      FloatingActionButton addPatient = rootView.findViewById(id);
      if (addPatient == null) {
        break missingId;
      }

      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = rootView.findViewById(id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.calendarView;
      CalendarView calendarView = rootView.findViewById(id);
      if (calendarView == null) {
        break missingId;
      }

      id = R.id.container_fragment;
      FrameLayout containerFragment = rootView.findViewById(id);
      if (containerFragment == null) {
        break missingId;
      }

      id = R.id.dayData;
      RadioButton dayData = rootView.findViewById(id);
      if (dayData == null) {
        break missingId;
      }

      id = R.id.homeRecycler;
      RecyclerView homeRecycler = rootView.findViewById(id);
      if (homeRecycler == null) {
        break missingId;
      }

      id = R.id.monthData;
      RadioButton monthData = rootView.findViewById(id);
      if (monthData == null) {
        break missingId;
      }

      id = R.id.rgTask;
      RadioGroup rgTask = rootView.findViewById(id);
      if (rgTask == null) {
        break missingId;
      }

      id = R.id.themainrecycle;
      LinearLayout themainrecycle = rootView.findViewById(id);
      if (themainrecycle == null) {
        break missingId;
      }

      id = R.id.vSep1;
      View vSep1 = rootView.findViewById(id);
      if (vSep1 == null) {
        break missingId;
      }

      id = R.id.vSep2;
      View vSep2 = rootView.findViewById(id);
      if (vSep2 == null) {
        break missingId;
      }

      id = R.id.weekData;
      RadioButton weekData = rootView.findViewById(id);
      if (weekData == null) {
        break missingId;
      }

      return new ActivityHomeBinding((RelativeLayout) rootView, addPatient, bottomNavigation,
          calendarView, containerFragment, dayData, homeRecycler, monthData, rgTask, themainrecycle,
          vSep1, vSep2, weekData);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
