package com.ninja.startup.marketplace.petblinders.dto;

public class AdicionarItemRequest {
    private CarrinhoDTO carrinho;
    private ItemDTO item;

    // Getters e Setters
    public CarrinhoDTO getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoDTO carrinho) {
        this.carrinho = carrinho;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public static class CarrinhoDTO {
        private String id;

        // Getters e Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class ItemDTO {
        private String id;
        private int quantidade;

        public ItemDTO() {
        }

        public ItemDTO(String id, int quantidade) {
            this.id = id;
            this.quantidade = quantidade;
        }

        // Getters e Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }
}
