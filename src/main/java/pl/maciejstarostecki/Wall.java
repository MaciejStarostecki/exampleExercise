/**
 * Implementacja metod w klasie Wall:
    - findBlockByColor
    - findBlocksByMaterial
    - count

 * Należy unikać powielania kodu
 * Umieścić całą logikę w klasie Wall


Z uwzględnieniem w analizie i implementacji interfejsu CompositeBlock!
*/

/*
Według polecenia całą logikę należało umieścić w jednej klasie Wall.
W moim odczuciu zadanie polegało na implementacji metod zawartych w interfejsie Structure
Nie dało się poprawnie zaimplementować interfejsu CompositeBlock bez tworzenia nowego obiektu, który go implementuje
oraz zawiera wymagane pola, jak kolor i materiał.
 */

package pl.maciejstarostecki;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;
    private final CompositeBlock compositeBlock;

    public Wall(List<Block> blocks, CompositeBlock compositeBlock) {
        this.blocks = blocks;
        this.compositeBlock = compositeBlock; //przed wstrzyknięciem obiektu przez konstruktor należy w innej klasie napisać implementację trzech metod: getBlocks() interfejsu CompositeBlock oraz getColor(), getMaterial() klasy Block, którą CompositeBlock implementuje.
    }

    /**
     * @param color     Parametr koloru, który jest przez funkcję wyszukiwany do znalezienia jakiegokolwiek elementu listy
     * @return          Zwraca dowolny element o podanym kolorze
     */
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().filter(x -> x.getColor().equals(color)).findAny();
    }


    /**
     *
     * @param material      Parametr materiału, który jest przez funkcję wyszukiwany do znalezienia wszystkich elementów listy
     * @return              Zwraca wszystkie elementy z danego materiału
     */
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return  blocks.stream().filter(x -> x.getMaterial().equals(material)).toList();
    }


    /**
     * @return Zwraca liczbę wszystkich elementów tworzących strukturę
     */
    @Override
    public int count() {
        return blocks.size();
    }

}


