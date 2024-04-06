package com.solution.repo;

import com.solution.domain.MenuCard;

import java.util.List;

public interface MenuRepo {

  List<MenuCard> allMenus();
  void addMenuCard(List<MenuCard> menuCard);
}
