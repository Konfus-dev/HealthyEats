package com.healthyeats.controller;

import android.graphics.Color;
import android.os.Bundle;
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

    public CardView createCard() {
        CardView card = new CardView(new ContextThemeWrapper(getContext(), R.style.recipeCardView));
        card.setLayoutParams(new CardView.LayoutParams(
                625, CardView.LayoutParams.MATCH_PARENT));
        ViewGroup.MarginLayoutParams layoutParams =
                (ViewGroup.MarginLayoutParams) card.getLayoutParams();
        layoutParams.setMargins(25, 0, 10, 10);
        card.requestLayout();
        return card;
    }

    public void createFullCard(String name, double price, String difficulty, LinearLayout parent) {
        CardView card = createCard();
        parent.addView(card);

        System.out.println("CARD HEIGHT " + card.getHeight());
        System.out.println("COUNT " + parent.getChildCount());

        ImageButton background = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.recipeBackgroundMain), null, 0);
        ImageButton heart = new ImageButton(new ContextThemeWrapper(getActivity(), R.style.recipeHeartIcon), null, 0);
        ImageView blueBackground = new ImageView(new ContextThemeWrapper(getActivity(), R.style.recipeBlueBackground), null, 0);
        TextView recipePrice = new TextView(getActivity());
        recipePrice.setTextAppearance(getActivity(), R.style.recipeCardPrice);
        TextView dietary = new TextView(getActivity());
        dietary.setTextAppearance(getActivity(), R.style.recipeCardDietary);
        ImageView difficultyImg = new ImageView(new ContextThemeWrapper(getActivity(), R.style.recipeCardDifficulty), null, 0);
        TextView recipeName = new TextView(getActivity());
        recipeName.setTextAppearance(getActivity(), R.style.recipeCardName);
        ImageView forkImage = new ImageView(new ContextThemeWrapper(getActivity(), R.style.recipeCardFork), null, 0);
        TextView recipeDifficultyText = new TextView(getActivity());
        recipeDifficultyText.setTextAppearance(getActivity(), R.style.recipeCardDifficultyText);

        card.addView(background);
//        card.addView(heart);
//        card.addView(blueBackground);
//        card.addView(recipePrice);
//        card.addView(dietary);
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
            createFullCard("Test", 5.00, "Beginner", trending);
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