package com.healthyeats.controller;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.healthyeats.R;
import com.healthyeats.model.CookbookViewModel;

public class CookbookFragment extends Fragment {

    private CookbookViewModel cookbookViewModel;
    LinearLayout trending;
    LinearLayout ourFavs;
    LinearLayout youShouldTry;
    LinearLayout bangForBuck;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cookbookViewModel =
                new ViewModelProvider(this).get(CookbookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cookbook, container, false);


        populateTrending(root, container);

        return root;
    }

    public int toDP(float dp) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        return (int) (metrics.density * dp + 0.5f);
    }

    // Create CardView template for all Cards on Cookbook page
    public CardView createCard() {
        // Card View Creation - Height | Width
        CardView card = new CardView(new ContextThemeWrapper(getContext(), R.style.recipeCardView));
        card.setLayoutParams(new CardView.LayoutParams(
                toDP(223), toDP(299)));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) card.getLayoutParams();
        layoutParams.setMargins(toDP(10), 0, 0, 0);
        card.requestLayout();

        return card;
    }

    // Creates the Heart Icon
    public ImageButton heart() {
        //Image Button Creation - Height | Width
        ImageButton heart = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.recipeHeartIcon), null, 0);
        heart.setLayoutParams(new LinearLayout.LayoutParams(toDP(46), toDP(40)));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) heart.getLayoutParams();
        layoutParams.setMargins(toDP(170), toDP(5), 0, 0);
        heart.requestLayout();

        // Set Scale
        heart.setScaleType(ImageView.ScaleType.FIT_XY);

        return heart;
    }

    // Sets the white footer at the bottom of each card
    public ImageView setWhiteFooter() {
        //Image Button Creation - Height | Width
        ImageView blueBackground = new ImageView(new ContextThemeWrapper(getActivity(), R.style.recipeBlueBackground), null, 0);
        blueBackground.setLayoutParams(new LinearLayout.LayoutParams(toDP(223), toDP(86)));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) blueBackground.getLayoutParams();
        layoutParams.setMargins(0, toDP(215), 0, 0);
        blueBackground.requestLayout();

        return blueBackground;
    }

    // Sets the price on the CookBook page
    public TextView setRecipePrice(int price) {
        // Text View Creation - Height | Width
        TextView recipePrice = new TextView(getActivity());
        recipePrice.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) recipePrice.getLayoutParams();
        layoutParams.setMargins(toDP(185), toDP(220), toDP(5), 0);
        recipePrice.requestLayout();

        //Set Text and Change Size
        recipePrice.setTextSize(toDP(5));
        recipePrice.setText("$" + Integer.toString(price));

        return recipePrice;
    }

    // Sets the dietary on theCookbook page
    public TextView setDietary() {
        // Text View Creation - Height | Width
        TextView dietary = new TextView(getActivity());
        dietary.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        // Margin
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) dietary.getLayoutParams();
        layoutParams.setMargins(toDP(145), toDP(260), 0, 0);
        dietary.requestLayout();

        //Set Text
        dietary.setText("Vegetarian");

        return dietary;
    }

    public ImageButton setDifficultyImg(String difficulty) {
        //Image Button Creation - Height | Width
        ImageView difficultyImg = new ImageView(new ContextThemeWrapper(getActivity(), R.style.recipeCardDifficulty), null, 0);


    }

    public void createFullCard(String name, int price, String difficulty, LinearLayout parent) {
        CardView card = createCard();
        parent.addView(card);

        ImageButton background = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.recipeBackgroundMain), null, 0);

        TextView recipeName = new TextView(getActivity());
        recipeName.setTextAppearance(getActivity(), R.style.recipeCardName);
        ImageView forkImage = new ImageView(new ContextThemeWrapper(getActivity(), R.style.recipeCardFork), null, 0);
        TextView recipeDifficultyText = new TextView(getActivity());
        recipeDifficultyText.setTextAppearance(getActivity(), R.style.recipeCardDifficultyText);

        card.addView(background);
        card.addView(heart());
        card.addView(setWhiteFooter());
        card.addView(setRecipePrice(price));
        card.addView(setDietary());
//        card.addView(difficultyImg);
//        card.addView(recipeName);
//        card.addView(forkImage);
//        card.addView(recipeDifficultyText);

        System.out.println("CARD COUNT " + card.getChildCount());
    }

    // Create 5 card views for trending section in cookbook
    public void populateTrending(View root, ViewGroup container) {
        trending = root.findViewById(R.id.cookBookTrending);
        System.out.println(trending);

        for (int i = 0; i < 5; i++) {
            createFullCard("Test", 230, "Beginner", trending);
//            System.out.println("YOLO " + i + "\n");
        }
    }

    // Create 5 card views for our favorites section in cookbook
    public void populateFavs() {
        ourFavs = getView().findViewById(R.id.cookBookOurFavorites);
        
    }

    // Create 5 card views for you should try section in cookbook
    public void populateYouShouldTry() {
        youShouldTry = getView().findViewById(R.id.cookBookYouShouldTry);
    }
    
    // Create 5 card views for bang for buck section in cookbook
    public void populateBangForBuck() {
        bangForBuck = getView().findViewById(R.id.cookBookBangForYourBuck);
    }
}