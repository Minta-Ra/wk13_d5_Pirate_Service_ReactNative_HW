import React from "react";
import ListItem from './ListItem';
import { View } from 'react-native';


export default function PirateList ({pirates}) {

    const piratesItems = pirates.map((pirate, index) => {
        return <ListItem pirate={pirate} key={index}/>
    });

    return (
        <View>
            {piratesItems}
        </View>
    );

};