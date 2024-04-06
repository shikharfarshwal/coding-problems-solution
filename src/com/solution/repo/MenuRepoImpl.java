package com.solution.repo;

import com.solution.domain.MenuCard;

import java.util.ArrayList;
import java.util.List;

public class MenuRepoImpl implements MenuRepo {


  public List<MenuCard> menuCards = new ArrayList<>();

  @Override
  public List<MenuCard> allMenus() {
    return menuCards;
  }

  @Override
  public void addMenuCard(final List<MenuCard> menuCard) {
    menuCards.addAll(menuCard);
  }


}
