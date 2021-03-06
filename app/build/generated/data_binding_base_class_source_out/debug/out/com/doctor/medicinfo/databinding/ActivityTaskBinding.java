// Generated by view binder compiler. Do not edit!
package com.doctor.medicinfo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.doctor.medicinfo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTaskBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FloatingActionButton addTask;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final FrameLayout containerFragment;

  @NonNull
  public final LinearLayout pastBtn;

  @NonNull
  public final LinearLayout searchTaskText;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final RecyclerView taskRecycler;

  @NonNull
  public final LinearLayout taskrecyclerlayout;

  @NonNull
  public final ViewPager2 viewpagerLine;

  private ActivityTaskBinding(@NonNull RelativeLayout rootView,
      @NonNull FloatingActionButton addTask, @NonNull BottomNavigationView bottomNavigation,
      @NonNull FrameLayout containerFragment, @NonNull LinearLayout pastBtn,
      @NonNull LinearLayout searchTaskText, @NonNull TabLayout tabLayout,
      @NonNull RecyclerView taskRecycler, @NonNull LinearLayout taskrecyclerlayout,
      @NonNull ViewPager2 viewpagerLine) {
    this.rootView = rootView;
    this.addTask = addTask;
    this.bottomNavigation = bottomNavigation;
    this.containerFragment = containerFragment;
    this.pastBtn = pastBtn;
    this.searchTaskText = searchTaskText;
    this.tabLayout = tabLayout;
    this.taskRecycler = taskRecycler;
    this.taskrecyclerlayout = taskrecyclerlayout;
    this.viewpagerLine = viewpagerLine;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTaskBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTaskBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_task, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTaskBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addTask;
      FloatingActionButton addTask = rootView.findViewById(id);
      if (addTask == null) {
        break missingId;
      }

      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = rootView.findViewById(id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.container_fragment;
      FrameLayout containerFragment = rootView.findViewById(id);
      if (containerFragment == null) {
        break missingId;
      }

      id = R.id.pastBtn;
      LinearLayout pastBtn = rootView.findViewById(id);
      if (pastBtn == null) {
        break missingId;
      }

      id = R.id.searchTaskText;
      LinearLayout searchTaskText = rootView.findViewById(id);
      if (searchTaskText == null) {
        break missingId;
      }

      id = R.id.tabLayout;
      TabLayout tabLayout = rootView.findViewById(id);
      if (tabLayout == null) {
        break missingId;
      }

      id = R.id.taskRecycler;
      RecyclerView taskRecycler = rootView.findViewById(id);
      if (taskRecycler == null) {
        break missingId;
      }

      id = R.id.taskrecyclerlayout;
      LinearLayout taskrecyclerlayout = rootView.findViewById(id);
      if (taskrecyclerlayout == null) {
        break missingId;
      }

      id = R.id.viewpager_line;
      ViewPager2 viewpagerLine = rootView.findViewById(id);
      if (viewpagerLine == null) {
        break missingId;
      }

      return new ActivityTaskBinding((RelativeLayout) rootView, addTask, bottomNavigation,
          containerFragment, pastBtn, searchTaskText, tabLayout, taskRecycler, taskrecyclerlayout,
          viewpagerLine);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
