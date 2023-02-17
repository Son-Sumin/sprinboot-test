package com.bitacademy.cocktail.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.cocktail.domain.CocktailRecipe;
import com.bitacademy.cocktail.domain.Ingredient;
import com.bitacademy.cocktail.service.CocktailRecipeService;
import com.bitacademy.cocktail.service.IngredientService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/ingredient")
@RequiredArgsConstructor
public class IngredientController {
	
	/* IngredientService, CocktailRecipeService 생성자 주입 */
	private final IngredientService ingredientService;
	private final CocktailRecipeService cocktailRecipeService;

	/* 재료 목록 */
	@GetMapping({"", "/list"})
	public String list(Model model) {
		List<Ingredient> ingredient = ingredientService.listIngredient();
		model.addAttribute("ingredient", ingredient);
		
		return "ingredient/ingredientList";
	}
	
	/* 재료 게시글 보기 + 재료별 칵테일 목록 */
	@GetMapping("/view/{no}")
	public String view(@PathVariable("no") Long no, Model model, CocktailRecipe cocktailRecipe) {
		// 재료 게시글 보기
		model.addAttribute("ingredient", ingredientService.findIngreView(no));
		
		// 재료별 칵테일 목록
		List<CocktailRecipe> list =  cocktailRecipeService.findByIngredient(no, cocktailRecipe);
		model.addAttribute("cocktailRecipes", list);
		
		return "ingredient/ingredientView";
	}
}
