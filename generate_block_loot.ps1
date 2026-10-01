$ErrorActionPreference = "Stop"

$lootDir = Join-Path $PSScriptRoot "src\main\resources\data\whatsits\loot_table\blocks"

New-Item -ItemType Directory -Force -Path $lootDir | Out-Null

function Write-SimpleBlockLoot {
    param(
        [Parameter(Mandatory = $true)]
        [string]$Name
    )

    $json = @"
{
  "type": "minecraft:block",
  "pools": [
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "whatsits:$Name"
        }
      ],
      "conditions": [
        {
          "condition": "minecraft:survives_explosion"
        }
      ]
    }
  ]
}
"@

    $path = Join-Path $lootDir "$Name.json"

    Set-Content `
        -Path $path `
        -Value $json `
        -Encoding UTF8

    Write-Host "Created $Name.json"
}

function Write-StackableBlockLoot {
    param(
        [Parameter(Mandatory = $true)]
        [string]$Name
    )

    $pools = @()

    for ($count = 1; $count -le 8; $count++) {

        $pool = @"
    {
      "rolls": 1,
      "entries": [
        {
          "type": "minecraft:item",
          "name": "whatsits:$Name",
          "functions": [
            {
              "function": "minecraft:set_count",
              "count": $count
            }
          ]
        }
      ],
      "conditions": [
        {
          "condition": "minecraft:block_state_property",
          "block": "whatsits:$Name",
          "properties": {
            "stack": "$count"
          }
        }
      ]
    }
"@

        $pools += $pool
    }

    $joinedPools = $pools -join ",`r`n"

    $json = @"
{
  "type": "minecraft:block",
  "pools": [
$joinedPools
  ]
}
"@

    $path = Join-Path $lootDir "$Name.json"

    Set-Content `
        -Path $path `
        -Value $json `
        -Encoding UTF8

    Write-Host "Created $Name.json"
}


# ---------------------------------
# Cakes / tarts / pies / pudding
# ---------------------------------

$simpleBlocks = @(
    "strawberry_cake",
    "sweetberry_cake",
    "chocolate_cake",
    "bundt_cake",
    "linzer_tart",
    "glowberry_tart",
    "pudding",
    "chocolate_gateau",
    "chocolate_tart",
    "apple_pie",
    "blank_cake",

    # Cupcakes
    "apple_cupcake_block",
    "sweetberry_cupcake_block",
    "strawberry_cupcake_block",

    # Cookies
    "chocolate_cookie_block",
    "sweetberry_cookie_block",
    "strawberry_cookie_block",

    # Breads
    "crusty_bread_block",
    "bread_block",
    "baguette_block",
    "toast_block",
    "braided_bread_block",
    "bun_block"
)

foreach ($block in $simpleBlocks) {
    Write-SimpleBlockLoot -Name $block
}


# ---------------------------------
# Stackable placeable blocks
# ---------------------------------

$stackableBlocks = @(
    "waffle_block",
    "jar",

    # Jam jars
    "strawberry_jam",
    "glowberry_jam",
    "sweetberry_jam",
    "chocolate_jam",
    "apple_jam"
)

foreach ($block in $stackableBlocks) {
    Write-StackableBlockLoot -Name $block
}

Write-Host ""
Write-Host "Finished generating placeable block loot tables."